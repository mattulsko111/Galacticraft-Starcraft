package starcraft.mods.galacticraft.venus;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVenusConfigManager 
{
	public static boolean loaded;
	
	static Configuration configuration;
	
	// DIMENSIONS
	public static int dimensionIDVenus;
	
	public GCVenusConfigManager(File file)
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
	        
	        dimensionIDVenus = 				configuration.get("Dimensions", 										"Mercury Dimension ID",				-21)		.getInt(-21);
	    }
		catch (final Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Galacticraft Venus has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
