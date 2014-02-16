package micdoodle8.mods.galacticraft.core.client.gui.overlay;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntityAutoRocket;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * GCCoreOverlayDockingRocket.java
 *
 * This file is part of the Galacticraft project
 *
 * @author micdoodle8
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@SideOnly(Side.CLIENT)
public class OverlayDockingRocket extends Overlay
{
    private static Minecraft minecraft = FMLClientHandler.instance().getClient();

    private static long screenTicks;

    /**
     * Render the GUI when player is docking a vehicle
     */
    public static void renderDockingOverlay()
    {
        OverlayDockingRocket.screenTicks++;
        final ScaledResolution scaledresolution = new ScaledResolution(OverlayDockingRocket.minecraft.gameSettings, OverlayDockingRocket.minecraft.displayWidth, OverlayDockingRocket.minecraft.displayHeight);
        final int width = scaledresolution.getScaledWidth();
        final int height = scaledresolution.getScaledHeight();
        OverlayDockingRocket.minecraft.entityRenderer.setupOverlayRendering();

        if (OverlayDockingRocket.minecraft.thePlayer.ridingEntity instanceof EntityAutoRocket)
        {
            EntityAutoRocket rocket = (EntityAutoRocket) OverlayDockingRocket.minecraft.thePlayer.ridingEntity;

            if (rocket.landing && rocket.targetVec != null)
            {
                double dX = Math.round((rocket.posX - rocket.targetVec.x) * 100.0D) / 100.0D;
                double dY = Math.round((rocket.posY - rocket.targetVec.y) * 100.0D) / 100.0D;
                double dZ = Math.round((rocket.posZ - rocket.targetVec.z) * 100.0D) / 100.0D;
                String dXStr = String.valueOf(dX);
                String dYStr = String.valueOf(dY);
                String dZStr = String.valueOf(dZ);

                String warning = "Press SPACE to decelerate";
                String warning2 = "Press LEFT SHIFT to accelerate";

                double targetMotionY = Math.round(Math.max((rocket.posY - rocket.targetVec.y) / -100.0D, -0.9D) * 100.0D) / 100.0D;
                double currentMotionY = Math.round(rocket.motionY * 100.0D) / 100.0D;
                double dMY = Math.floor((targetMotionY - currentMotionY) * 300);
                int dMotionY = (int) Math.max(1, Math.min(255, dMY));
                int dMotionYN = (int) Math.max(1, Math.min(255, -dMY));
                String targetMotionYStr = "Target velocity: " + String.valueOf(targetMotionY);
                String currentMotionYStr = "Current velocity: " + String.valueOf(currentMotionY);

                int red = GCCoreUtil.to32BitColor(dMY > 0 ? 0 : dMotionYN, 255, 255, 255);
                int green = GCCoreUtil.to32BitColor(dMY < 0 ? 0 : dMotionY, 255, 255, 255);
                int grey = GCCoreUtil.to32BitColor(255, 220, 220, 220);

                if (dMY > 25)
                {
                    OverlayDockingRocket.minecraft.fontRenderer.drawString(warning, width / 2 - OverlayDockingRocket.minecraft.fontRenderer.getStringWidth(warning) / 2, height / 3 - 50, green);
                }

                if (dMY < -25)
                {
                    OverlayDockingRocket.minecraft.fontRenderer.drawString(warning2, width / 2 - OverlayDockingRocket.minecraft.fontRenderer.getStringWidth(warning2) / 2, height / 3 - 35, red);
                }

                OverlayDockingRocket.minecraft.fontRenderer.drawString(targetMotionYStr, width - OverlayDockingRocket.minecraft.fontRenderer.getStringWidth(targetMotionYStr) - 50, height / 3 + 50, grey);
                OverlayDockingRocket.minecraft.fontRenderer.drawString(currentMotionYStr, width - OverlayDockingRocket.minecraft.fontRenderer.getStringWidth(currentMotionYStr) - 50, height / 3 + 35, grey);

                OverlayDockingRocket.minecraft.fontRenderer.drawString("Distance from Target", 50, height / 3 + 15, grey);
                OverlayDockingRocket.minecraft.fontRenderer.drawString("X: " + dXStr, 50, height / 3 + 35, Math.abs(dX) > 15 ? red : grey);
                OverlayDockingRocket.minecraft.fontRenderer.drawString("Y: " + dYStr, 50, height / 3 + 45, Math.abs(dY) > 50 || Math.abs(dY) < 1.9 ? grey : OverlayDockingRocket.screenTicks / 10 % 2 == 0 ? red : grey);
                OverlayDockingRocket.minecraft.fontRenderer.drawString("Z: " + dZStr, 50, height / 3 + 55, Math.abs(dZ) > 15 ? red : grey);
            }
        }
    }
}
