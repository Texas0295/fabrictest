package fabrictest.entries;

import fabrictest.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class CellEntity extends ThrownItemEntity implements FlyingItemEntity {
    public CellEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public CellEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
        super(ModEntities.THROWABLE_CELL_ENTRY_ENTITY_TYPE, d, e, f, world);
    }

    public CellEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(ModEntities.THROWABLE_CELL_ENTRY_ENTITY_TYPE, livingEntity, world);
    }

    public CellEntity(World world, LivingEntity owner){
        super(ModEntities.THROWABLE_CELL_ENTRY_ENTITY_TYPE,owner,world);

    }
    @Override
    protected Item getDefaultItem() {
        return ModItems.CELLS;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!world.isClient){
            world.createExplosion(this,this.lastRenderX,this.lastRenderY,this.lastRenderZ,10, Explosion.DestructionType.DESTROY);
        }
        this.kill();
    }
}
