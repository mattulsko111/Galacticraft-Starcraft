package starcraft.mods.galacticraft.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name="Starcraft Core", version="v1", useMetadata = false, modid = "StarcraftCore")
@NetworkMod(channels = {"StarcraftCore"}, clientSideRequired = true, serverSideRequired = false)
public class StarcraftCore {

}
