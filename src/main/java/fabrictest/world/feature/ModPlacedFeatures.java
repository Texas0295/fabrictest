package fabrictest.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {
        public static final RegistryEntry<PlacedFeature> BIZARRE_POLYMER_UPPER_PLACED = PlacedFeatures
                        .register("bizarre_polymer_upper_placed", ModConfiguredFeature.BIZARRE_POLYMER, ModOreFeatures
                                        .modifiersWithCount(90, HeightRangePlacementModifier.uniform(YOffset.fixed(0),
                                                        YOffset.getTop())));
        public static final RegistryEntry<PlacedFeature> BIZARRE_POLYMER_LOWER_PLACED = PlacedFeatures.register(
                        "bizarre_polymer_lower_placed", ModConfiguredFeature.BIZARRE_POLYMER,
                        ModOreFeatures.modifiersWithCount(20,
                                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-1))));
}
