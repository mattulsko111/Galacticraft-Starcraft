package micdoodle8.mods.galacticraft.core.blocks;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCCoreBlockCrudeOil extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    public Icon[] fluidIcons;

    public GCCoreBlockCrudeOil(int par1, Material par2Material)
    {
        super(par1, GCCoreBlocks.CRUDEOIL, par2Material);
        this.setQuantaPerBlock(3);
        this.setTickRate(15);
        this.setRenderPass(1);
        this.needsRandomTick = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par1 != 0 && par1 != 1 ? this.fluidIcons[1] : this.fluidIcons[0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.fluidIcons = new Icon[] { par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "oil"), par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "oil_flow") };
        GCCoreBlocks.CRUDEOIL.setStillIcon(this.fluidIcons[0]);
        GCCoreBlocks.CRUDEOIL.setFlowingIcon(this.fluidIcons[1]);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        super.randomDisplayTick(world, x, y, z, rand);

        if (rand.nextInt(1200) == 0)
        {
            world.playSound(x + 0.5F, y + 0.5F, z + 0.5F, "liquid.lava", rand.nextFloat() * 0.25F + 0.75F, 0.00001F + rand.nextFloat() * 0.5F, false);
        }
    }
}
