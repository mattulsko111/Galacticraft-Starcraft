package micdoodle8.mods.galacticraft.saturn.client;

import micdoodle8.mods.galacticraft.API.IGalaxy;
import micdoodle8.mods.galacticraft.API.IMapPlanet;
import micdoodle8.mods.galacticraft.API.IPlanetSlotRenderer;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCSaturnMapPlanet implements IMapPlanet
{
	@Override
	public float getPlanetSize() 
	{
		return 15F * 9.41F;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 14240F;
	}

	@Override
	public float getPhaseShift() 
	{
		return 2880F / 3F;
	}

	@Override
	public float getStretchValue() 
	{
		return 29.7F;
	}

	@Override
	public IPlanetSlotRenderer getSlotRenderer() 
	{
		return new GCSaturnSlotRenderer();
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}
}
