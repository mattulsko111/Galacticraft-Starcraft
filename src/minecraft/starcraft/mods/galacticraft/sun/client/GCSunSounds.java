package starcraft.mods.galacticraft.sun.client;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class GCSunSounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
        }
        catch (final Exception e)
        {
            System.err.println("[GCSun] Failed to register one or more sounds.");
        }
    }
}