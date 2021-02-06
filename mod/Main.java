package joost.mod;

import javax.tools.DocumentationTool.Location;

import joost.mod.client.AncientEvents;
import joost.mod.enchantment.EnchantmentFly;
import joost.mod.helpers.KeybindHandler;
import joost.mod.init.ItemInit;
import joost.mod.potion.PotionFly;
import joost.mod.potion.PotionTypeRegistry;
import joost.mod.proxy.CommonProxy;
import joost.mod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import scala.swing.event.Key;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	public static final Enchantment FLY = new EnchantmentFly(Rarity.VERY_RARE, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});
	public static final Potion FLY_POTION = new PotionFly();
	public static int side = 2; //1: passive, 2:attack, 3: defend, 4: water
	public static int spell = 1; //side sub catogory
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{
		ForgeRegistries.ENCHANTMENTS.register(FLY);
		ForgeRegistries.POTIONS.register(FLY_POTION);
		PotionTypeRegistry.registerPotionTypes();
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new AncientEvents());
		
		KeyBinding[] openAttacks2 = {new KeyBinding("key.Attacks", Key.Up().id(), "key.categories.main")};
	     boolean[] repeat = {false};
	     ClientRegistry.registerKeyBinding(openAttacks2);
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {}
	
	
}

