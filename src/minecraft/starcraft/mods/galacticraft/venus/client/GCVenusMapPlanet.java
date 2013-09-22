package starcraft.mods.galacticraft.venus.client;

import micdoodle8.mods.galacticraft.API.IGalaxy;
import micdoodle8.mods.galacticraft.API.IMapPlanet;
import micdoodle8.mods.galacticraft.API.IPlanetSlotRenderer;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCVenusMapPlanet implements IMapPlanet
{
	@Override
	public float getPlanetSize() 
	{
		return 15;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 1000F;
	}

	@Override
	public float getPhaseShift() 
	{
		return 2350F;
	}

	@Override
	public float getStretchValue() 
	{
		return 11.86F;
	}

	@Override
	public IPlanetSlotRenderer getSlotRenderer() 
	{
		return new GCVenusSlotRenderer();
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}
}