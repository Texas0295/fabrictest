package fabrictest.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block BIZARRE_POLYMER = new BizarrePolymer(FabricBlockSettings.of(Material.STONE), UniformIntProvider.create(0,0));
    public static void register(){
        Registry.register(Registry.BLOCK,new Identifier("fabrictest","bizarre_polymer"), BIZARRE_POLYMER);
    }
}
