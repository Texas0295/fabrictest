package fabrictest.entries;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import com.google.common.collect.Sets;

import fabrictest.blocks.ModBlocks;
import fabrictest.items.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.EntityExplosionBehavior;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

public class CellEntity extends ThrownItemEntity {
    public CellEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public CellEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
        super(ModEntities.THROWABLE_CELL_ENTRY_ENTITY_TYPE, d, e, f, world);
    }

    public CellEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(ModEntities.THROWABLE_CELL_ENTRY_ENTITY_TYPE, livingEntity, world);
    }

    public CellEntity(World world, LivingEntity owner) {
        super(ModEntities.THROWABLE_CELL_ENTRY_ENTITY_TYPE, owner, world);

    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.CELLS;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!world.isClient) {
            Explosion explosion = new Explosion(world, this, this.lastRenderX, this.lastRenderY, this.lastRenderZ, 10,
                    false,
                    Explosion.DestructionType.DESTROY);
            var affectedBlocks = getAffectedBlocks(explosion, this.lastRenderX, this.lastRenderY,
                    this.lastRenderZ, 10, new EntityExplosionBehavior(this));

            for (BlockPos blockPos : affectedBlocks) {
                if (this.world.getBlockState(blockPos).getBlock().equals(ModBlocks.BIZARRE_POLYMER)) {
                    this.world.setBlockState(blockPos, ModBlocks.CELL_TURNED_POLYMER.getDefaultState());
                }
            }
            world.createExplosion(this, lastRenderX, lastRenderY, lastRenderZ, 10, Explosion.DestructionType.DESTROY);
        }
        this.kill();
    }

    @SuppressWarnings("all")
    public ObjectArrayList<BlockPos> getAffectedBlocks(Explosion explosion, double x, double y, double z,
            int power, ExplosionBehavior behavior) {
        int l;
        int k;
        HashSet<BlockPos> set = Sets.newHashSet();
        for (int j = 0; j < 16; ++j) {
            for (k = 0; k < 16; ++k) {
                block2: for (l = 0; l < 16; ++l) {
                    if (j != 0 && j != 15 && k != 0 && k != 15 && l != 0 && l != 15)
                        continue;
                    double d = (float) j / 15.0f * 2.0f - 1.0f;
                    double e = (float) k / 15.0f * 2.0f - 1.0f;
                    double f = (float) l / 15.0f * 2.0f - 1.0f;
                    double g = Math.sqrt(d * d + e * e + f * f);
                    d /= g;
                    e /= g;
                    f /= g;
                    double m = x;
                    double n = y;
                    double o = z;
                    for (float h = power * (0.7f + world.random.nextFloat() * 0.6f); h > 0.0f; h -= 0.22500001f) {
                        BlockPos blockPos = new BlockPos(m, n, o);
                        BlockState blockState = world.getBlockState(blockPos);
                        FluidState fluidState = world.getFluidState(blockPos);
                        if (!world.isInBuildLimit(blockPos))
                            continue block2;
                        Optional<Float> optional = behavior.getBlastResistance(explosion, world, blockPos, blockState,
                                fluidState);
                        if (optional.isPresent()) {
                            h -= (optional.get().floatValue() + 0.3f) * 0.3f;
                        }
                        if (h > 0.0f && behavior.canDestroyBlock(explosion, world, blockPos, blockState, h)) {
                            set.add(blockPos);
                        }
                        m += d * (double) 0.3f;
                        n += e * (double) 0.3f;
                        o += f * (double) 0.3f;
                    }
                }
            }
        }
        ObjectArrayList<BlockPos> affectedBlocks = new ObjectArrayList();
        affectedBlocks.addAll((Collection<BlockPos>) set);
        return affectedBlocks;
    }
}
