package fabrictest.blocks;

import net.minecraft.block.Block;
import net.minecraft.world.explosion.Explosion;

public class CellTurnedPolymer extends Block {
    public CellTurnedPolymer(Settings settings) {
        super(settings);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }
}
