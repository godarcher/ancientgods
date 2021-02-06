package joost.mod.helpers;

import joost.mod.Main;
import joost.mod.init.ItemInit;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.swing.event.Key;

@SideOnly(Side.CLIENT)
public class KeybindHandler 
{
	public static KeyBinding openAttacks;
	public static KeyBinding openDefences;
	public static KeyBinding openPassive;
	public static KeyBinding openWater;

    public static  void registerKeybinds() 
    {
    	//setting up the keybindings
        openAttacks = new KeyBinding("key.Attacking", Key.Up().id(), "key.categories.main");
        openDefences = new KeyBinding("key.Defending", Key.Down().id(), "key.categories.main");
        openPassive = new KeyBinding("key.Passive", Key.Left().id(), "key.categories.main");
        openWater = new KeyBinding("key.Water", Key.Right().id(), "key.categories.main");
        //registering keybindings to the Client.
        ClientRegistry.registerKeyBinding(openAttacks);
        ClientRegistry.registerKeyBinding(openDefences);
        ClientRegistry.registerKeyBinding(openPassive);
        ClientRegistry.registerKeyBinding(openWater);
    }
    
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Minecraft.getMinecraft().inGameHasFocus) {
            if (KeybindHandler.openAttacks.isPressed()) 
            {
            	if (Minecraft.getMinecraft().player.inventory.armorItemInSlot(3) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(3).getItem() == ItemInit.POSEIDON_HELMET
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(2) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(2).getItem() == ItemInit.POSEIDON_CHESTPLATE
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(1) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(1).getItem() == ItemInit.POSEIDON_LEGGINGS
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(0) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(0).getItem() == ItemInit.POSEIDON_BOOTS)
            	{
            		if (Main.side == 2)
                	{
                		Minecraft.getMinecraft().player.sendChatMessage("Attacking Powers are already selected.");
                	}
                	else 
                	{
                		
                		Main.side = 2;
                		Minecraft.getMinecraft().player.sendChatMessage("Attacking Powers Selected");
                	}
            	}
            }
            else if (KeybindHandler.openDefences.isPressed()) 
            {
            	if (Minecraft.getMinecraft().player.inventory.armorItemInSlot(3) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(3).getItem() == ItemInit.POSEIDON_HELMET
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(2) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(2).getItem() == ItemInit.POSEIDON_CHESTPLATE
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(1) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(1).getItem() == ItemInit.POSEIDON_LEGGINGS
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(0) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(0).getItem() == ItemInit.POSEIDON_BOOTS)
            	{
            		if (Main.side == 3)
                	{
                		Minecraft.getMinecraft().player.sendChatMessage("Defensive Powers are already selected.");
                	}
                	else 
                	{
                		Minecraft.getMinecraft().player.inventory.damageArmor(3000);
                		Main.side = 3;
                		Minecraft.getMinecraft().player.sendChatMessage("Defensive Powers Selected");
                	}
            	}
            }
            else if (KeybindHandler.openPassive.isPressed()) 
            {
            	if (Minecraft.getMinecraft().player.inventory.armorItemInSlot(3) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(3).getItem() == ItemInit.POSEIDON_HELMET
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(2) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(2).getItem() == ItemInit.POSEIDON_CHESTPLATE
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(1) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(1).getItem() == ItemInit.POSEIDON_LEGGINGS
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(0) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(0).getItem() == ItemInit.POSEIDON_BOOTS)
            	{
            		if (Main.side == 1)
                	{
                		Minecraft.getMinecraft().player.sendChatMessage("Passive Powers are already selected.");
                	}
                	else 
                	{
                		Main.side = 1;
                		Minecraft.getMinecraft().player.sendChatMessage("Passive Powers Selected");
                	}
            	}
            }
            else if (KeybindHandler.openWater.isPressed()) 
            {
            	if (Minecraft.getMinecraft().player.inventory.armorItemInSlot(3) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(3).getItem() == ItemInit.POSEIDON_HELMET
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(2) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(2).getItem() == ItemInit.POSEIDON_CHESTPLATE
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(1) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(1).getItem() == ItemInit.POSEIDON_LEGGINGS
        				&& Minecraft.getMinecraft().player.inventory.armorItemInSlot(0) != null && Minecraft.getMinecraft().player.inventory.armorItemInSlot(0).getItem() == ItemInit.POSEIDON_BOOTS)
            	{
            		if (Main.side == 4)
                	{
                		Minecraft.getMinecraft().player.sendChatMessage("Other Powers are already selected.");
                	}
                	else 
                	{
                		Main.side = 4;
                		Minecraft.getMinecraft().player.sendChatMessage("Other Powers Selected");
                	}
            	}
            }
        }
    }
}
