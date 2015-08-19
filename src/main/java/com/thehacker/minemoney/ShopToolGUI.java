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
public class ShopToolGUI {

public static Object instance;

public static int GUIID = 53;

public ShopToolGUI(){}

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

	int xp = entity.experienceTotal;
	
	this.fontRendererObj.drawString("MineMoney = " + xp, posX+(100), posY+(-120), 0xffffff);
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

this.buttonList.add(new GuiButton(0, posX+(-180), posY+(-100), 140, 20, "Diamond Axe = 900"));
this.buttonList.add(new GuiButton(1, posX+(-180), posY+(-80), 140, 20, "Golden Axe = 600"));
this.buttonList.add(new GuiButton(2, posX+(-180), posY+(-60), 140, 20, "Iron Axe= 200"));
this.buttonList.add(new GuiButton(3, posX+(-180), posY+(-40), 140, 20, "Stone Axe = 50"));
this.buttonList.add(new GuiButton(4, posX+(-180), posY+(-20), 140, 20, "Wooden Axe = 10"));

this.buttonList.add(new GuiButton(5, posX+(-20), posY+(-100), 140, 20, "Diamond Pickaxe = 900"));
this.buttonList.add(new GuiButton(6, posX+(-20), posY+(-80), 140, 20, "Golden Pickaxe = 600"));
this.buttonList.add(new GuiButton(7, posX+(-20), posY+(-60), 140, 20, "Iron Pickaxe = 200"));
this.buttonList.add(new GuiButton(8, posX+(-20), posY+(-40), 140, 20, "Stone Pickaxe = 50"));
this.buttonList.add(new GuiButton(9, posX+(-20), posY+(-20), 140, 20, "Wooden Pickaxe = 10"));

this.buttonList.add(new GuiButton(10, posX+(-180), posY+(20), 140, 20, "Diamond Shovel = 300"));
this.buttonList.add(new GuiButton(11, posX+(-180), posY+(40), 140, 20, "Golden Shovel = 200"));
this.buttonList.add(new GuiButton(12, posX+(-180), posY+(60), 140, 20, "Iron Shovel = 75"));
this.buttonList.add(new GuiButton(13, posX+(-180), posY+(80), 140, 20, "Stone Shovel = 20"));
this.buttonList.add(new GuiButton(14, posX+(-180), posY+(100), 140, 20, "Wooden Shovel = 5"));

this.buttonList.add(new GuiButton(15, posX+(-20), posY+(20), 140, 20, "Diamond Hoe = 350"));
this.buttonList.add(new GuiButton(16, posX+(-20), posY+(40), 140, 20, "Golden Hoe = 150"));
this.buttonList.add(new GuiButton(17, posX+(-20), posY+(60), 140, 20, "Iron Hoe = 75"));
this.buttonList.add(new GuiButton(18, posX+(-20), posY+(80), 140, 20, "Stone Hoe = 15"));
this.buttonList.add(new GuiButton(19, posX+(-20), posY+(100), 140, 20, "Wooden Hoe = 10"));

}

protected void actionPerformed(GuiButton button)
{
int number = Integer.parseInt(ItemInput.getText());
int type =  0;
if(number >= 0){
	if (button.id == 0)BuyEvent(900, Items.diamond_axe, number, type);
	if (button.id == 1)BuyEvent(600, Items.golden_axe, number, type);
	if (button.id == 2)BuyEvent(200, Items.iron_axe, number, type);
	if (button.id == 3)BuyEvent(50, Items.stone_axe, number, type);
	if (button.id == 4)BuyEvent(10, Items.wooden_axe, number, type);
	
	if (button.id == 5)BuyEvent(900, Items.diamond_pickaxe, number, type);
	if (button.id == 6)BuyEvent(600, Items.golden_pickaxe, number, type);
	if (button.id == 7)BuyEvent(200, Items.iron_pickaxe, number, type);
	if (button.id == 8)BuyEvent(50, Items.stone_pickaxe, number, type);
	if (button.id == 9)BuyEvent(10, Items.wooden_pickaxe, number, type);
	
	if (button.id == 10)BuyEvent(300, Items.diamond_shovel, number, type);
	if (button.id == 11)BuyEvent(200, Items.golden_shovel, number, type);
	if (button.id == 12)BuyEvent(75, Items.iron_shovel, number, type);
	if (button.id == 13)BuyEvent(20, Items.stone_shovel, number, type);
	if (button.id == 14)BuyEvent(5, Items.wooden_shovel, number, type);
	
	if (button.id == 15)BuyEvent(350, Items.diamond_hoe, number, type);
	if (button.id == 16)BuyEvent(150, Items.golden_hoe, number, type);
	if (button.id == 17)BuyEvent(75, Items.iron_hoe, number, type);
	if (button.id == 18)BuyEvent(15, Items.stone_hoe, number, type);
	if (button.id == 19)BuyEvent(10, Items.wooden_hoe, number, type);
}
if(number < 0){
	if (button.id == 0)SellEvent(900, Items.diamond_axe, number, type);
	if (button.id == 1)SellEvent(600, Items.golden_axe, number, type);
	if (button.id == 2)SellEvent(200, Items.iron_axe, number, type);
	if (button.id == 3)SellEvent(50, Items.stone_axe, number, type);
	if (button.id == 4)SellEvent(10, Items.wooden_axe, number, type);

	if (button.id == 5)SellEvent(900, Items.diamond_pickaxe, number, type);
	if (button.id == 6)SellEvent(600, Items.golden_pickaxe, number, type);
	if (button.id == 7)SellEvent(200, Items.iron_pickaxe, number, type);
	if (button.id == 8)SellEvent(50, Items.stone_pickaxe, number, type);
	if (button.id == 9)SellEvent(10, Items.wooden_pickaxe, number, type);

	if (button.id == 10)SellEvent(300, Items.diamond_shovel, number, type);
	if (button.id == 11)SellEvent(200, Items.golden_shovel, number, type);
	if (button.id == 12)SellEvent(75, Items.iron_shovel, number, type);
	if (button.id == 13)SellEvent(20, Items.stone_shovel, number, type);
	if (button.id == 14)SellEvent(5, Items.wooden_shovel, number, type);

	if (button.id == 15)SellEvent(350, Items.diamond_hoe, number, type);
	if (button.id == 16)SellEvent(150, Items.golden_hoe, number, type);
	if (button.id == 17)SellEvent(75, Items.iron_hoe, number, type);
	if (button.id == 18)SellEvent(15, Items.stone_hoe, number, type);
	if (button.id == 19)SellEvent(10, Items.wooden_hoe, number, type);
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
