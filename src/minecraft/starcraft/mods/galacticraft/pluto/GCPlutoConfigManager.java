package starcraft.mods.galacticraft.pluto;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCPlutoConfigManager 
{
	public static boolean loaded;
	
	static Configuration configuration;
	
	// DIMENSIONS
	public static int dimensionIDPluto;
	
	public GCPlutoConfigManager(File file)
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
	        
	        dimensionIDPluto = 				configuration.get("Dimensions", 										"Pluto Dimension ID",				-30)		.getInt(-30);
	    }
		catch (final Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Galacticraft Pluto has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
