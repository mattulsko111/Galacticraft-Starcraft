package starcraft.mods.galacticraft.mercury;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCMercuryConfigManager 
{
	public static boolean loaded;
	
	static Configuration configuration;
	
	// DIMENSIONS
	public static int dimensionIDMercury;
	
	public GCMercuryConfigManager(File file)
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
	        
	        dimensionIDMercury = 				configuration.get("Dimensions", 										"Mercury Dimension ID",				-20)		.getInt(-20);
	    }
		catch (final Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Galacticraft Mercury has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
