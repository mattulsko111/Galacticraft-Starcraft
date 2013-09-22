package starcraft.mods.galacticraft.mercury;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.common.DimensionManager;
import micdoodle8.mods.galacticraft.API.IGalacticraftSubMod;
import micdoodle8.mods.galacticraft.API.IGalaxy;
import micdoodle8.mods.galacticraft.core.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.europa.GCEuropaConfigManager;
import starcraft.mods.galacticraft.mercury.dimension.GCMercuryWorldProvider;
import starcraft.mods.galacticraft.mercury.GalacticraftMercury;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarted;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name="Galacticraft Mercury", version="v1", useMetadata = false, modid = "GalacticraftMercury")
@NetworkMod(channels = {"GalacticraftMercury"}, clientSideRequired = true, serverSideRequired = false)
public class GalacticraftMercury implements IGalacticraftSubMod
{

	@SidedProxy(clientSide = "starcraft.mods.galacticraft.mercury.client.ClientProxyMercury", serverSide = "starcraft.mods.galacticraft.mercury.CommonProxyMercury")
	public static CommonProxyMercury proxy;
	
	@Instance("GalacticraftMercury")
	public static GalacticraftMercury instance;
	
	public static List mercuryPlayers = new ArrayList();
	public static List gcMercuryPlayers = new ArrayList();
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		GalacticraftCore.registerSubMod(this);
		
		new GCMercuryConfigManager(new File(event.getModConfigurationDirectory(), "Galacticraft/mercury.conf"));
		
		proxy.preInit(event);
	}

	@Init
	public void load(FMLInitializationEvent event)
	{
		DimensionManager.registerProviderType(GCMercuryConfigManager.dimensionIDMercury, GCMercuryWorldProvider.class, true);
		DimensionManager.registerDimension(GCMercuryConfigManager.dimensionIDMercury, GCMercuryConfigManager.dimensionIDMercury);
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		proxy.init(event);
	}

	public void registerTileEntities()
	{
		
	}
	
	public void registerCreatures()
	{
		
	}
	
	public void registerOtherEntities()
	{
		
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
		proxy.registerRenderInformation();
	}
	
	@ServerStarted
	public void serverStarted(FMLServerStartedEvent event)
	{
		 NetworkRegistry.instance().registerChannel(new ServerPacketHandler(), "GcMercury", Side.SERVER);
	}

	public void registerGalacticraftCreature(Class var0, String var1, int id, int back, int fore)
    {
    	EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, instance, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("entity." + var1 + ".name", "en_US", var1);
    }
    
    public void registerGalacticraftNonMobEntity(Class var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
	
    public class ServerPacketHandler implements IPacketHandler
    {
        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
        {
            final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
            final int packetType = GCCoreUtil.readPacketID(data);
            final EntityPlayerMP player = (EntityPlayerMP)p;
            
            if (packetType == 0)
            {
            	
            }
        }
    }
	
	@Override
	public String getDimensionName() 
	{
		return "Mercury";
	}

	@Override
	public boolean reachableDestination() 
	{
		return true;
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}
}
