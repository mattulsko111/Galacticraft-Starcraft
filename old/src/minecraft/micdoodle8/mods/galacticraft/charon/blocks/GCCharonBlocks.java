package micdoodle8.mods.galacticraft.charon.blocks;

import net.minecraft.block.Block;
import micdoodle8.mods.galacticraft.pluto.client.ClientProxyPluto;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GCCharonBlocks 
{
	public static void initBlocks() 
	{	
	}

	public static void setHarvestLevels() 
	{
	}
	
	public static void registerBlocks() 
	{
	}

	public static void addNames() 
	{
	}
	
	private static void addName(Block block)
	{
		LanguageRegistry.instance().addStringLocalization(block.getBlockName() + ".name", ClientProxyPluto.lang.get(block.getBlockName() + ".name"));
	}
	
	private static void addNameWithMetadata(String string)
	{
		LanguageRegistry.instance().addStringLocalization(string, ClientProxyPluto.lang.get(string));
	}
}
