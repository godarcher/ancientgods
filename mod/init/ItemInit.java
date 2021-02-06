package joost.mod.init;

import java.util.ArrayList;
import java.util.List;

import joost.mod.object.armor.ArmourBase;
import joost.mod.object.items.ItemBase;
import joost.mod.object.tools.ToolSword;
import joost.mod.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//material
	public static final ToolMaterial TOOL_GODLY = EnumHelper.addToolMaterial("tool_godly", 4, 99999, 10.0F, 10.0f, 1); //DIAMOND(3, 1561, 8.0F, 3.0F, 10),
	public static final ArmorMaterial ARMOR_GODLY = EnumHelper.addArmorMaterial("armor_godly", Reference.MODID + ":godly", 50, new int[]{9, 15, 19, 9}, 1, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 3.0f); //DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	
	//items
	public static final Item GODLY_INGOT = new ItemBase("ingot_godly");
	
	public static final Item POSEIDON_TRIDENT = new ToolSword("trident_poseidon", TOOL_GODLY);
	public static final Item POSEIDON_HELMET = new ArmourBase("helmet_godly", ARMOR_GODLY, 1, EntityEquipmentSlot.HEAD);
	public static final Item POSEIDON_CHESTPLATE = new ArmourBase("chestplate_godly", ARMOR_GODLY, 1, EntityEquipmentSlot.CHEST);
	public static final Item POSEIDON_LEGGINGS = new ArmourBase("leggins_godly", ARMOR_GODLY, 2, EntityEquipmentSlot.LEGS);
	public static final Item POSEIDON_BOOTS = new ArmourBase("boots_godly", ARMOR_GODLY, 1, EntityEquipmentSlot.FEET);
}
