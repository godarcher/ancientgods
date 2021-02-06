package joost.mod.object.armor;

import joost.mod.Main;
import joost.mod.init.ItemInit;
import joost.mod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ArmourBase extends ItemArmor implements IHasModel
{
	public ArmourBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) 
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) 
	{
		if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ItemInit.POSEIDON_HELMET
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ItemInit.POSEIDON_CHESTPLATE
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ItemInit.POSEIDON_LEGGINGS
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ItemInit.POSEIDON_BOOTS) {
			this.effectPlayer(player, Potion.getPotionById(1), 0, 159); //speed - general
			this.effectPlayer(player, Potion.getPotionById(5), 0, 159); //strength - general
			this.effectPlayer(player, Potion.getPotionById(8), 0, 159); //jumpboost - general
			///this.effectPlayer(player, Potion.getPotionById(16), 0); //night vision - general - disabled due to irritating effect
			this.effectPlayer(player, Potion.getPotionById(21), 0, 11159); //health boost - general
			this.effectPlayer(player, Potion.getPotionById(26), 0, 159); //luck - general
			this.effectPlayer(player, Potion.getPotionById(13), 0, 159); //water breathing - unique poseidon
			this.effectPlayer(player, Potion.getPotionById(12), 0, 159); //fire resistance - unique poseidon (god of water cant burn right)
			
			
			
			//final int var1 = MathHelper.floor(player.posX);
			//final int var2 = MathHelper.floor(player.posY - 0.20000000298023224D);
			//final int var3 = MathHelper.floor(player.posY);
			//final BlockPos var4 = new BlockPos(var1, var2, var3);
			//final IBlockState var5 = world.getBlockState(var4);
			//final Block var6 = var5.getBlock();
			
			int x = (int) Math.floor(player.posX);
			int y = (int) (player.posY - player.getYOffset());
			int z = (int) Math.floor(player.posZ);
			
			 //do something with the players motion.
			BlockPos pos = new BlockPos(x, y - 1, z);
			BlockPos pos2 = new BlockPos(x, y, z); //actual player position
			if (player.world.getBlockState(pos).getBlock() == Blocks.DIRT)
			{
				 if (player.motionY < 0)
				 {
					 player.world.setBlockState(pos, Blocks.GRASS.getDefaultState());
				 }
				 
			}
			else if (player.world.getBlockState(pos).getBlock() == Blocks.ICE)
			{
				 if (player.motionY < 0)
				 {
					 player.world.setBlockState(pos, Blocks.WATER.getDefaultState());
				 }
				 
			}
			else if (player.world.getBlockState(pos).getMaterial() == Material.LAVA)
			{
				if (player.motionY < 0)
				 {
					player.world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
				 }
			}
			else if (player.world.getBlockState(pos2).getMaterial() == Material.FIRE)
			{
				if (player.motionY < 0)
				 {
					player.world.setBlockState(pos2, Blocks.AIR.getDefaultState());
				 }
			}
			if (player.world.getBlockState(pos2).getBlock() == Blocks.WATER)
			{
				if (player.motionY < 0)
				 {
					this.effectPlayer(player, Potion.getPotionById(10), 0, 159); //we give Poseidon regeneration in the water.
					this.effectPlayer(player, Main.FLY_POTION, 0, 11159); //we make poseidon have fly while in the water so hes faster while in the water then everybody else.
				 }
			}
			else
			{
				player.removePotionEffect(Main.FLY_POTION);
				
				 //world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, x, y + 1, z, 0.1D, 1.0D, 0.0D, new int[0]);
				 //world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, x, y + 1, z, 0.0D, 1.2D, 0.1D, new int[0]);
				 //world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, x, y + 1, z, 0.0D, 0.5D, 0.1D, new int[0]);
				 //world.spawnParticle(EnumParticleTypes.WATER_DROP, x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
				 //world.spawnParticle(EnumParticleTypes.WATER_SPLASH, x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
				 //world.spawnParticle(EnumParticleTypes.WATER_WAKE, x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
				 
				
			}
		}
	}

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier, int duration) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
				player.addPotionEffect(new PotionEffect(potion, duration, amplifier, false, false));
	}
}
