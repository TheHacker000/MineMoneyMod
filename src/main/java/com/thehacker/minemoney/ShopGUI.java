package com.thehacker.minemoney;

import java.util.Random;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("unchecked")
public class ShopGUI {

public static Object instance;

public static int GUIID = 50;

public ShopGUI(){}

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
@Override public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {if(id==3)return new mcreator_shopGUI.GuiContainerMod(player);else return null;}
@Override public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {if(id==3)return new mcreator_shopGUI.GuiWindow(world, x, y, z, player);else return null;}
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

}

public void updateScreen()
{

}

protected void keyTyped(char par1, int par2)
{


if (par2 != 28 && par2 != 156){
	if (par2 == 1){
		this.mc.displayGuiScreen((GuiScreen)null);
	}
}

}

protected void drawGuiContainerForegroundLayer(int par1, int par2){
	int posX = (this.width) /2;
	int posY = (this.height) /2;
	this.fontRendererObj.drawString("Shopping Book", posX+(-180), posY+(-100), 0xffffff);

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
this.buttonList.add(new GuiButton(0, posX+(-180), posY+(-80), 350, 20, "Item Shop"));
this.buttonList.add(new GuiButton(1, posX+(-180), posY+(-60), 350, 20, "Block Shop"));
this.buttonList.add(new GuiButton(2, posX+(-180), posY+(-40), 350, 20, "Tool Shop"));
this.buttonList.add(new GuiButton(3, posX+(-180), posY+(-20), 350, 20, "Armor Shop"));
this.buttonList.add(new GuiButton(4, posX+(-180), posY+(0), 350, 20, "Food Shop"));
}

protected void actionPerformed(GuiButton button)
{
MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
World world = server.worldServers[0];


if (button.id == 0)
if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, ShopItemGUI.GUIID, world, i, j, k);

if (button.id == 1)
if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, ShopBlockGUI.GUIID, world, i, j, k);

if (button.id == 2)
if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, ShopToolGUI.GUIID, world, i, j, k);

if (button.id == 3)
if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, ShopArmorGUI.GUIID, world, i, j, k);

if (button.id == 4)
if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, ShopFoodGUI.GUIID, world, i, j, k);

}

public boolean doesGuiPauseGame()
{
    return false;
}

}

}
