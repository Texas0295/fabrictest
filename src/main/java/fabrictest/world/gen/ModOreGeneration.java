package fabrictest.world.gen;

import fabrictest.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep.Feature;

public class ModOreGeneration {
    public static void ore() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.BIZARRE_POLYMER_UPPER_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.BIZARRE_POLYMER_LOWER_PLACED.getKey().get());
    }
}
