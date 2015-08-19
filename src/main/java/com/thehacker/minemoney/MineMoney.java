package com.thehacker.minemoney;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MineMoney.MODID, version = MineMoney.VERSION)
public class MineMoney implements IFuelHandler, IWorldGenerator{

	public static final String MODID = "MineMoney";
    public static final String VERSION = "0.1.3";

	@SidedProxy(clientSide="com.thehacker.minemoney.ClientProxyMineMoney", serverSide="com.thehacker.minemoney.CommonProxyMineMoney")
    //@SidedProxy(clientSide="com.thehacker.minemoney.ClientProxyMineMoney", serverSide="com.thehacker.minemoney.CommonProxyMineMoney")
    public static CommonProxyMineMoney proxy;
    //public static EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel("MCRBUS", new ChannelHandlerMineMoney());

	@Instance(MODID)
    public static MineMoney instance;

	ShopItemGUI mod_0 = new ShopItemGUI();
	ShopBook mod_1 = new ShopBook();
	ShopGUI mod_2 = new ShopGUI();
	ShopBlockGUI mod_3 = new ShopBlockGUI();
	ShopToolGUI mod_4 = new ShopToolGUI();
	ShopArmorGUI mod_5 = new ShopArmorGUI();
	ShopFoodGUI mod_6 = new ShopFoodGUI();


@Override
public int getBurnTime(ItemStack fuel) {
if(mod_0.addFuel(fuel)!=0) return mod_0.addFuel(fuel);
if(mod_1.addFuel(fuel)!=0) return mod_1.addFuel(fuel);
if(mod_2.addFuel(fuel)!=0) return mod_2.addFuel(fuel);
if(mod_3.addFuel(fuel)!=0) return mod_3.addFuel(fuel);
if(mod_4.addFuel(fuel)!=0) return mod_4.addFuel(fuel);
if(mod_5.addFuel(fuel)!=0) return mod_5.addFuel(fuel);
if(mod_6.addFuel(fuel)!=0) return mod_6.addFuel(fuel);
return 0;
}

@Override
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

chunkX = chunkX * 16;
chunkZ = chunkZ * 16;
if(world.provider.getDimensionId()==-1)mod_0.generateNether(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==0)mod_0.generateSurface(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==-1)mod_1.generateNether(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==0)mod_1.generateSurface(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==-1)mod_2.generateNether(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==0)mod_2.generateSurface(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==-1)mod_3.generateNether(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==0)mod_3.generateSurface(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==-1)mod_4.generateNether(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==0)mod_4.generateSurface(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==-1)mod_5.generateNether(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==0)mod_5.generateSurface(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==-1)mod_6.generateNether(world, random, chunkX, chunkZ);
if(world.provider.getDimensionId()==0)mod_6.generateSurface(world, random, chunkX, chunkZ);


}
@EventHandler
public void load(FMLInitializationEvent event) {
GameRegistry.registerFuelHandler(this);
GameRegistry.registerWorldGenerator(this, 1);
NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
mod_0.load(event);
mod_1.load(event);
mod_2.load(event);
mod_3.load(event);
mod_4.load(event);
mod_5.load(event);
mod_6.load(event);
}
@EventHandler
public void serverLoad(FMLServerStartingEvent event){
mod_0.serverLoad(event);
mod_1.serverLoad(event);
mod_2.serverLoad(event);
mod_3.serverLoad(event);
mod_4.serverLoad(event);
mod_5.serverLoad(event);
mod_6.serverLoad(event);
}
@EventHandler
public void preInit(FMLPreInitializationEvent event){
ShopItemGUI.instance = MineMoney.instance;
ShopBook.instance = MineMoney.instance;
ShopGUI.instance = MineMoney.instance;
ShopBlockGUI.instance = MineMoney.instance;
ShopToolGUI.instance = MineMoney.instance;
ShopArmorGUI.instance = MineMoney.instance;
ShopFoodGUI.instance = MineMoney.instance;
mod_0.preInit(event);
mod_1.preInit(event);
mod_2.preInit(event);
mod_3.preInit(event);
mod_4.preInit(event);
mod_5.preInit(event);
mod_6.preInit(event);
proxy.registerRenderers(this);
}
public static class GuiHandler implements IGuiHandler {
@Override 
public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
if(id == ShopItemGUI.GUIID)return new ShopItemGUI.GuiContainerMod(player);
if(id == ShopGUI.GUIID)return new ShopGUI.GuiContainerMod(player);
if(id == ShopBlockGUI.GUIID)return new ShopBlockGUI.GuiContainerMod(player);
if(id == ShopToolGUI.GUIID)return new ShopToolGUI.GuiContainerMod(player);
if(id == ShopArmorGUI.GUIID)return new ShopArmorGUI.GuiContainerMod(player);
if(id == ShopFoodGUI.GUIID)return new ShopFoodGUI.GuiContainerMod(player);
return null;
}
@Override 
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
if(id == ShopItemGUI.GUIID)return new ShopItemGUI.GuiWindow(world, x, y, z, player);
if(id == ShopGUI.GUIID)return new ShopGUI.GuiWindow(world, x, y, z, player);
if(id == ShopBlockGUI.GUIID)return new ShopBlockGUI.GuiWindow(world, x, y, z, player);
if(id == ShopToolGUI.GUIID)return new ShopToolGUI.GuiWindow(world, x, y, z, player);
if(id == ShopArmorGUI.GUIID)return new ShopArmorGUI.GuiWindow(world, x, y, z, player);
if(id == ShopFoodGUI.GUIID)return new ShopFoodGUI.GuiWindow(world, x, y, z, player);
return null;
}
}
}
