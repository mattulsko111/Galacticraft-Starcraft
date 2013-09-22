package starcraft.mods.galacticraft.pluto.client;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class GCPlutoSounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
        }
        catch (final Exception e)
        {
            System.err.println("[GCPluto] Failed to register one or more sounds.");
        }
    }
}