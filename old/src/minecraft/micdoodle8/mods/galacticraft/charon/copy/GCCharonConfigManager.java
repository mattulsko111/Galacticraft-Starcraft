package micdoodle8.mods.galacticraft.charon.copy;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCCharonConfigManager 
{
	public static boolean loaded;
	
	static Configuration configuration;
	
	// DIMENSIONS
	public static int dimensionIDCharon;
	
	// BLOCKS
	public static int idBlock;
	public static int idBlockPyroxene;
	
	public GCCharonConfigManager(File file)
	{
		if (!loaded)
		{
			configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}
	
	private void setDefaultValues()
    {
		try
		{
	        configuration.load();
	        
	        dimensionIDCharon = 				configuration.get("Dimensions", 										"Charon Dimension ID",				-31)		.getInt(-31);
	    
	        idBlock = 						configuration.get(Configuration.CATEGORY_BLOCK, 						"idBlockCharon", 					199)	.getInt(199);
	        idBlockPyroxene =  				configuration.get(Configuration.CATEGORY_BLOCK, 						"idBlockPyroxene", 				195)	.getInt(195);
		}
		catch (final Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Galacticraft Charon has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
