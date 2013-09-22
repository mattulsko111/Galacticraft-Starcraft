package starcraft.mods.galacticraft.sun;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCSunConfigManager 
{
	public static boolean loaded;
	
	static Configuration configuration;
	
	// DIMENSIONS
	public static int dimensionIDSun;
	
	public GCSunConfigManager(File file)
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
	        
	        dimensionIDSun = 				configuration.get("Dimensions", 										"Sun Dimension ID",				-19)		.getInt(-19);
	    }
		catch (final Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Galacticraft Sun has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
