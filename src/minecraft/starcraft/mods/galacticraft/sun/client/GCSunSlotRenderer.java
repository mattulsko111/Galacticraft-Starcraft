package starcraft.mods.galacticraft.sun.client;

import micdoodle8.mods.galacticraft.API.IPlanetSlotRenderer;
import net.minecraft.client.renderer.Tessellator;

public class GCSunSlotRenderer implements IPlanetSlotRenderer
{
	@Override
	public String getPlanetSprite() 
	{
		return "/starcraft/mods/galacticraft/sun/client/planets/sun.png";
	}

	@Override
	public String getPlanetName() 
	{
		return "Sun";
	}

	@Override
	public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator) 
	{
		tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV(x - slotHeight / 2 * 1.3, 	y + slotHeight / 2 * 1.3, 	-90.0D, 0.35D, 0.65D);
	    tessellator.addVertexWithUV(x + slotHeight / 2 * 1.3, 	y + slotHeight / 2 * 1.3, 	-90.0D, 0.65D, 0.65D);
	    tessellator.addVertexWithUV(x + slotHeight / 2 * 1.3, 	y - slotHeight / 2 * 1.3, 	-90.0D, 0.65D, 0.35D);
	    tessellator.addVertexWithUV(x - slotHeight / 2 * 1.3, 	y - slotHeight / 2 * 1.3, 	-90.0D, 0.35D, 0.35D);
	    tessellator.draw();
	}
}
