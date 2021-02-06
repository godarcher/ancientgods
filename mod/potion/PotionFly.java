package joost.mod.potion;

import joost.mod.util.Reference;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionFly extends Potion
{
	public PotionFly() {
		super(false, 8376831);
		setPotionName("effect.fly");
		setIconIndex(3, 2);
		setRegistryName(new ResourceLocation(Reference.MODID + ":" + "fly"));
	}
}
