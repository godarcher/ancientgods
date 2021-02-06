package joost.mod.init;

import java.util.ArrayList;
import java.util.List;

import joost.mod.object.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_GODLY = new BlockBase("block_godly", Material.IRON, 47.0f);
}
