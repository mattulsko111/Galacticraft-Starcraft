package micdoodle8.mods.galacticraft.core.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * GCMoonItem.java
 * 
 * This file is part of the Galacticraft project
 * 
 * @author micdoodle8
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemMoon extends Item
{
	public static String[] names = { "meteoric_iron_ingot", "compressedMeteoricIron" };
	protected IIcon[] icons = new IIcon[ItemMoon.names.length];

	public ItemMoon()
	{
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		int i = 0;

		for (String name : ItemMoon.names)
		{
			this.icons[i++] = iconRegister.registerIcon(GalacticraftCore.ASSET_PREFIX + name);
		}
	}

	@Override
	public IIcon getIconFromDamage(int damage)
	{
		if (this.icons.length > damage)
		{
			return this.icons[damage];
		}

		return super.getIconFromDamage(damage);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < ItemMoon.names.length; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		if (this.icons.length > par1ItemStack.getItemDamage())
		{
			return "item." + ItemMoon.names[par1ItemStack.getItemDamage()];
		}

		return "unnamed";
	}

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return GalacticraftCore.galacticraftTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxy.galacticraftItem;
	}
}
