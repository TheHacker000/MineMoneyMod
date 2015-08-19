package com.thehacker.minemoney;

import java.util.Random;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("unchecked")
public class ShopFoodGUI {

public static Object instance;

public static int GUIID = 55;

public ShopFoodGUI(){}

public void load(FMLInitializationEvent event){
	//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
}

public void registerRenderers(){}
public void generateNether(World world, Random random, int chunkX, int chunkZ){}
public void generateSurface(World world, Random random, int chunkX, int chunkZ){}
public int addFuel(ItemStack fuel){
	return 0;
}
public void serverLoad(FMLServerStartingEvent event){}
public void preInit(FMLPreInitializationEvent event){}

/*public static class GuiHandler implements IGuiHandler {
@Override public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {if(id==9)return new mcreator_shopItemGUI.GuiContainerMod(player);else return null;}
@Override public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {if(id==9)return new mcreator_shopItemGUI.GuiWindow(world, x, y, z, player);else return null;}
}*/

public static class GuiContainerMod extends Container {

        public GuiContainerMod (EntityPlayer player){
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return true;
        }


        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
                return null;
        }
}

public static class GuiWindow extends GuiContainer
{

	int i = 0;
	int j = 0;
	int k = 0;
	EntityPlayer entity = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().playerEntityList.get(0);

	
GuiTextField ItemInput;

public GuiWindow(World world, int i, int j, int k, EntityPlayer entity){
	super(new GuiContainerMod((EntityPlayer)entity));
	this.i = i;
	this.j = j;
	this.k = k;
	this.entity = entity;
}

private static final ResourceLocation texture = new ResourceLocation("ShopItemGUI.png");

protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
{
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	
this.mc.renderEngine.bindTexture(texture);
this.xSize=375;
this.ySize=225;
int k = (this.width - this.xSize) / 2;
int l = (this.height - this.ySize) / 2;
this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);


    zLevel = 100.0F;
    

}

protected void mouseClicked(int par1, int par2, int par3) throws java.io.IOException
{
super.mouseClicked(par1, par2, par3);

this.ItemInput.mouseClicked(par1, par2, par3);
}

public void updateScreen()
{
this.ItemInput.updateCursorCounter();
}

protected void keyTyped(char par1, int par2)
{

this.ItemInput.textboxKeyTyped(par1, par2);

if (par2 != 28 && par2 != 156){
	if (par2 == 1){
		this.mc.displayGuiScreen((GuiScreen)null);
	}
}

}

protected void drawGuiContainerForegroundLayer(int par1, int par2){
	int posX = (this.width) /2;
	int posY = (this.height) /2;
	this.fontRendererObj.drawString("Item Amount:", posX+(-180), posY+(-120), 0xffffff);
	this.fontRendererObj.drawString("MineMoney = " + entity.experienceTotal, posX+(100), posY+(-120), 0xffffff);
	this.ItemInput.drawTextBox();
}

public void onGuiClosed()
{
Keyboard.enableRepeatEvents(false);
}

public void initGui(){
Keyboard.enableRepeatEvents(true);
this.buttonList.clear();
int posX = (this.width) / 2;
int posY = (this.height) / 2;


this.ItemInput = new GuiTextField(0, this.fontRendererObj, posX+(-115), posY+(-120), 100, 15);
this.ItemInput.setMaxStringLength(10);
this.ItemInput.setText("1");

this.buttonList.add(new GuiButton(0, posX+(-180), posY+(-100), 120, 20, "Apple = " + 50));
this.buttonList.add(new GuiButton(1, posX+(-180), posY+(-80), 120, 20, "Mushroom Stew = " + 100));
this.buttonList.add(new GuiButton(2, posX+(-180), posY+(-60), 120, 20, "Bread = " + 25));
this.buttonList.add(new GuiButton(3, posX+(-180), posY+(-40), 120, 20, "Cooked Porkchop = " + 75));
this.buttonList.add(new GuiButton(4, posX+(-180), posY+(-20), 120, 20, "Cooked Fish = " + 150));
this.buttonList.add(new GuiButton(5, posX+(-180), posY+(0), 120, 20, "Cooked Salmon = " + 150));
this.buttonList.add(new GuiButton(6, posX+(-180), posY+(20), 120, 20, "Cake = " + 150));
this.buttonList.add(new GuiButton(7, posX+(-180), posY+(40), 120, 20, "Cookie = " + 20));
this.buttonList.add(new GuiButton(8, posX+(-180), posY+(60), 120, 20, "Melon = " + 25));

this.buttonList.add(new GuiButton(9, posX+(-60), posY+(-100), 120, 20, "Steak = " + 50));
this.buttonList.add(new GuiButton(10, posX+(-60), posY+(-80), 120, 20, "Cooked Chicken = " + 30));
this.buttonList.add(new GuiButton(11, posX+(-60), posY+(-60), 120, 20, "Carrot = " + 15));
this.buttonList.add(new GuiButton(12, posX+(-60), posY+(-40), 120, 20, "Potato = " + 20));
this.buttonList.add(new GuiButton(13, posX+(-60), posY+(-20), 120, 20, "Baked Potato = " + 30));
this.buttonList.add(new GuiButton(14, posX+(-60), posY+(0), 120, 20, "Pumpkin Pie = " + 125));
this.buttonList.add(new GuiButton(15, posX+(-60), posY+(20), 120, 20, "Cooked Rabbit = " + 50));
this.buttonList.add(new GuiButton(16, posX+(-60), posY+(40), 120, 20, "Rabbit Stew = " + 150));
this.buttonList.add(new GuiButton(17, posX+(-60), posY+(60), 120, 20, "Cooked Mutton = " + 75));

}

protected void actionPerformed(GuiButton button)
{

int number = Integer.parseInt(ItemInput.getText());
int type =  0;
if(number >= 0){
	if (button.id == 0)BuyEvent(50, Items.apple, number, type);
	if (button.id == 1)BuyEvent(100, Items.mushroom_stew, number, type);
	if (button.id == 2)BuyEvent(25, Items.bread, number, type);
	if (button.id == 3)BuyEvent(75, Items.cooked_porkchop, number, type);
	if (button.id == 4)BuyEvent(150, Items.cooked_fish, number, type);
	if (button.id == 5)BuyEvent(150, Items.cooked_fish, number, 1);
	if (button.id == 6)BuyEvent(150, Items.cake, number, type);
	if (button.id == 7)BuyEvent(20, Items.cookie, number, type);
	if (button.id == 8)BuyEvent(25, Items.melon, number, type);
	if (button.id == 9)BuyEvent(50, Items.cooked_beef, number, type);
	if (button.id == 10)BuyEvent(30, Items.cooked_chicken, number, type);
	if (button.id == 11)BuyEvent(15, Items.carrot, number, type);
	if (button.id == 12)BuyEvent(20, Items.potato, number, type);
	if (button.id == 13)BuyEvent(30, Items.baked_potato, number, type);
	if (button.id == 14)BuyEvent(125, Items.pumpkin_pie, number, type);
	if (button.id == 15)BuyEvent(50, Items.cooked_rabbit, number, type);
	if (button.id == 16)BuyEvent(150, Items.rabbit_stew, number, type);
	if (button.id == 17)BuyEvent(75, Items.cooked_mutton, number, type);
}
if(number < 0){
	if (button.id == 0)SellEvent(50, Items.apple, number, type);
	if (button.id == 1)SellEvent(100, Items.mushroom_stew, number, type);
	if (button.id == 2)SellEvent(25, Items.bread, number, type);
	if (button.id == 3)SellEvent(75, Items.cooked_porkchop, number, type);
	if (button.id == 4)SellEvent(150, Items.cooked_fish, number, type);
	if (button.id == 5)SellEvent(150, Items.cooked_fish, number, 1);
	if (button.id == 6)SellEvent(150, Items.cake, number, type);
	if (button.id == 7)SellEvent(20, Items.cookie, number, type);
	if (button.id == 8)SellEvent(25, Items.melon, number, type);
	if (button.id == 9)SellEvent(50, Items.cooked_beef, number, type);
	if (button.id == 10)SellEvent(30, Items.cooked_chicken, number, type);
	if (button.id == 11)SellEvent(15, Items.carrot, number, type);
	if (button.id == 12)SellEvent(20, Items.potato, number, type);
	if (button.id == 13)SellEvent(30, Items.baked_potato, number, type);
	if (button.id == 14)SellEvent(125, Items.pumpkin_pie, number, type);
	if (button.id == 15)SellEvent(50, Items.cooked_rabbit, number, type);
	if (button.id == 16)SellEvent(150, Items.rabbit_stew, number, type);
	if (button.id == 17)SellEvent(75, Items.cooked_mutton, number, type);
}

}
public static void BuyEvent (int value, Item item, int number, int type){
	ShopSystem.BuyItem(value, item, number, type);
		
}
public static void SellEvent (int value, Item item, int number, int type){
	ShopSystem.SellItem(value, item, number, type);
}
public boolean doesGuiPauseGame()
{
    return false;
}

}

}
