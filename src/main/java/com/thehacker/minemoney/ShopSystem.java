package com.thehacker.minemoney;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class ShopSystem {
	static EntityPlayer entity = (EntityPlayer)MinecraftServer.getServer().getConfigurationManager().playerEntityList.get(0);
	static float xp = entity.experienceTotal;
	
	public static void BuyItem(int value, Item item, int number, int type){
		if(entity.experienceTotal >= value * number){
			entity.inventory.addItemStackToInventory(new ItemStack(item, number, type));
			removeExperience(value);
		}
		if(entity.experienceTotal < value * number){
			
		}
	}
	public static void SellItem(int value, Item item, int number, int type){
		if(entity.inventory.hasItemStack(new ItemStack (item, (-1)*(number), type))){
			for( ; number < 0;number++){
				entity.inventory.consumeInventoryItem(item);
				entity.addExperience(value);
			}
		}
		if(entity.inventory.hasItemStack(new ItemStack(item, 0, type))){
			
		}
	}
	public static void BuyBlock(int value, Block block, int number, int type){
		if(entity.experienceTotal >= value * number){
			entity.inventory.addItemStackToInventory(new ItemStack(block, number, type));
			removeExperience(value);
		}
		if(entity.experienceTotal < value){
			
		}
	}
	public static void SellBlock(int value, Block block, int number, int type){
		if(entity.inventory.hasItemStack(new ItemStack (block, (-1)*(number), type))){
			for( ; number < 0;number++){
				entity.inventory.consumeInventoryItem(Item.getItemFromBlock(block));
				entity.addExperience(value);
			}
		}
		if(entity.inventory.hasItemStack(new ItemStack(block, 0, type))){
			
		}
	}	
	public static void removeExperience(int amount){
		entity.addScore((-1) * amount);
        int j = Integer.MIN_VALUE + entity.experienceTotal;

        if (amount < j)
        {
            amount = j;
        }

        entity.experience -= (float)amount / (float)entity.xpBarCap();

        for (entity.experienceTotal -= amount; entity.experience <= 0.0F; entity.experience /= (float)entity.xpBarCap())
        {
            entity.experience = (entity.experience + 1.0F) * (float)entity.xpBarCap();
            entity.removeExperienceLevel(1);
        }
	}
}
