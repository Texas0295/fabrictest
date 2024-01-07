package fabrictest.blocks;

import net.minecraft.block.Block;
import net.minecraft.world.explosion.Explosion;

public class BizarrePolymer extends Block {
    public BizarrePolymer(Settings settings) {
        super(settings);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return true;
    }

}
