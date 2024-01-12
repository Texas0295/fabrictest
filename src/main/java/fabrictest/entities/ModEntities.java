package fabrictest.entities;

import fabrictest.entities.projectile.CellEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<CellEntity> THROWABLE_CELL_ENTRY_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("throwable_cell"),
            FabricEntityTypeBuilder.<CellEntity>create(
                    SpawnGroup.MISC, CellEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(5).trackedUpdateRate(10)
                    .build());

    public static void register() {

    }
}
