package joost.mod.client;

import java.lang.reflect.Field;
import java.util.Map;

import javax.swing.text.JTextComponent.KeyBinding;

import akka.actor.ActorSystem.Settings;
import joost.mod.Main;
import joost.mod.helpers.KeybindHandler;
import joost.mod.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import scala.swing.event.Key;

public class AncientEvents 
{
	@SubscribeEvent
	public void onFly(TickEvent.PlayerTickEvent event) {
		boolean fly = false;
		if(event.player.inventory.armorInventory.get(0) != null) {
			int f = EnchantmentHelper.getEnchantmentLevel(Main.FLY, event.player.inventory.armorInventory.get(0));
			if(f != 0)
				fly = true;
		}
		if(event.player.isPotionActive(Main.FLY_POTION))
			fly = true;
		if(fly || event.player.isCreative() || event.player.isSpectator()) {
			event.player.capabilities.allowFlying = true;
			event.player.fallDistance = 0.0f;
		} else {
			fly = false;
			event.player.capabilities.isFlying = false;
			event.player.capabilities.allowFlying = false;
		}
	}
	
	@SubscribeEvent
	public void onMouseInput(InputEvent.MouseInputEvent event)
	{
		EntityPlayerSP player = FMLClientHandler.instance().getClient().player;
		EnumHand hand = EnumHand.MAIN_HAND;
		
		if(FMLClientHandler.instance().getClient().inGameHasFocus &&
				player.getHeldItem(hand).getItem() == ItemInit.POSEIDON_TRIDENT &&
				FMLClientHandler.instance().getClient().currentScreen == null 
				)
			
		{
			if(Minecraft.getMinecraft().gameSettings.keyBindUseItem.isPressed()) //use keylispressed when it is registered properly.
			{
				int x = (int) Math.floor(player.getLookVec().x);
				int y = (int) (player.getLookVec().y);
				int z = (int) Math.floor(player.getLookVec().y);
			}
		}
		else if(FMLClientHandler.instance().getClient().inGameHasFocus &&
				player.getHeldItem(hand).getItem() == Items.BUCKET &&
				FMLClientHandler.instance().getClient().currentScreen == null 
				)
			
		{
			if(Minecraft.getMinecraft().gameSettings.keyBindUseItem.isPressed()) //use keylispressed when it is registered properly.
			{
				player.setHeldItem(hand, Items.WATER_BUCKET.getDefaultInstance());
			}
		}
		else if (FMLClientHandler.instance().getClient().inGameHasFocus &&
				player.getHeldItem(hand).getItem() == Items.GLASS_BOTTLE &&
				FMLClientHandler.instance().getClient().currentScreen == null 
				)
			
		{
			if(Minecraft.getMinecraft().gameSettings.keyBindUseItem.isPressed()) //use keylispressed when it is registered properly.
			{
				player.setHeldItem(hand, Items.POTIONITEM.getDefaultInstance());
			}
		}
	}
	 
	
	//mcObject.fontRenderer.drawStringWithShadow("Hello World!", 4 /*X*/, 4 /*Y*/, 0xffFFFFFF /*COLOUR*/);

}
