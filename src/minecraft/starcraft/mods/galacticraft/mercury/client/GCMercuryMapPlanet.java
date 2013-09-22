package starcraft.mods.galacticraft.mercury.client;

import micdoodle8.mods.galacticraft.API.IGalaxy;
import micdoodle8.mods.galacticraft.API.IMapPlanet;
import micdoodle8.mods.galacticraft.API.IPlanetSlotRenderer;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCMercuryMapPlanet implements IMapPlanet
{
	@Override
	public float getPlanetSize() 
	{
		return 15F * 11.1F;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 7780F;
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
		return new GCMercurySlotRenderer();
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}
}