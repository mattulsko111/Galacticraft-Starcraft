package starcraft.mods.galacticraft.venus.client;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class GCVenusSounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
        }
        catch (final Exception e)
        {
            System.err.println("[GCVenus] Failed to register one or more sounds.");
        }
    }
}