package fabrictest.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.WorldAccess;

public class BizarrePolymer extends Block {
    private UniformIntProvider experienceDropped;

    public BizarrePolymer(Settings settings, UniformIntProvider provider) {
        super(settings);
        this.experienceDropped = provider;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);
    }
}
