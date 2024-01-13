package fabrictest.entities;

import fabrictest.blocks.ModBlocks;
import fabrictest.entities.block.UnknownMachineEntity;
import fabrictest.entities.projectile.CellEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
        public static final EntityType<CellEntity> CELL_ENTITY_TYPE = Registry.register(
                        Registry.ENTITY_TYPE,
                        new Identifier("cell_entity"),
                        FabricEntityTypeBuilder.<CellEntity>create(
                                        SpawnGroup.MISC, CellEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                                        .trackRangeBlocks(5).trackedUpdateRate(10)
                                        .build());

        public static final BlockEntityType<UnknownMachineEntity> UNKNOWN_MACHINE_BLOCK_ENTITY_TYPE = Registry.register(
                        Registry.BLOCK_ENTITY_TYPE, new Identifier("fabrictest", "unknown_machine_entity"),
                        FabricBlockEntityTypeBuilder.create(UnknownMachineEntity::new, ModBlocks.UNKNOWN_MACHINE)
                                        .build());

        public static void register() {

        }
}
