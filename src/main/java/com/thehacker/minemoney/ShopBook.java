package com.thehacker.minemoney;

import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.fml.relauncher.*;
import net.minecraft.block.*;
import net.minecraft.client.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.minecraft.init.*;

import java.util.*;

import net.minecraft.client.resources.model.*;


@SuppressWarnings("unchecked")
public class ShopBook{

public ShopBook(){}

public static Item block;
public static Object instance;public void load(FMLInitializationEvent event){
if(event.getSide() == Side.CLIENT)
Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(block, 0, new ModelResourceLocation("minemoney:ShopBook", "inventory"));

GameRegistry.addRecipe(new ItemStack(block, 1), new Object[]{
	"X1X", "3X5", "X7X", Character.valueOf('1'), new ItemStack(Blocks.cobblestone, 1), Character.valueOf('3'), new ItemStack(Blocks.planks, 1), Character.valueOf('5'), new ItemStack(Items.wheat_seeds, 1), Character.valueOf('7'), new ItemStack(Items.coal, 1), 
});new ChestGenHooks("bonusChest").addItem(new WeightedRandomChestContent(new ItemStack(block), 1, 1, 100));}
public void generateNether(World world, Random random, int chunkX, int chunkZ){}
public void generateSurface(World world, Random random, int chunkX, int chunkZ){}
public int addFuel(ItemStack fuel){return 0;}
public void serverLoad(FMLServerStartingEvent event){}
public void preInit(FMLPreInitializationEvent event){}
public void registerRenderers(){
}


static{
block = (new ItemshopBook(446));

}

static class ItemshopBook extends Item{

public ItemshopBook(int par1){
setMaxDamage(0);
maxStackSize = 1;
setUnlocalizedName("ShopBook");
GameRegistry.registerItem(this, "ShopBook");
setCreativeTab(CreativeTabs.tabMisc);
}
public int getItemEnchantability()
{
    return 0;
}
public int getMaxItemUseDuration(ItemStack par1ItemStack)
{
    return 0;
}
public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
{
    return 1.0F;
}
@Override
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, ShopGUI.GUIID, world, i, j, k);
return itemstack;
}
@Override
public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entity, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
int i = pos.getX();
int j = pos.getY();
int k = pos.getZ();

if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, ShopGUI.GUIID, world, i, j, k);
return true;
}
@SuppressWarnings("rawtypes")
public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
{
list.add("To Spend Your MineMoney");
}




}}
