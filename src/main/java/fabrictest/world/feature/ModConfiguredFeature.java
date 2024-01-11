package fabrictest.world.feature;

import java.util.List;

import fabrictest.blocks.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ModConfiguredFeature {

        public static final List<OreFeatureConfig.Target> OVERWORLD_BIZARRE_POLYMER = List.of(
                        OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                                        ModBlocks.BIZARRE_POLYMER.getDefaultState()),
                        OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                                        ModBlocks.BIZARRE_POLYMER.getDefaultState()));
        public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> BIZARRE_POLYMER = ConfiguredFeatures
                        .register("bizarre_polymer", Feature.ORE, new OreFeatureConfig(OVERWORLD_BIZARRE_POLYMER, 9));

        public static void register() {
        }
}
