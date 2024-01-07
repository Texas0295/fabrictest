package fabrictest.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block BIZARRE_POLYMER = ModBlocks.registerBlock("bizarre_polymer",
            new BizarrePolymer(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block CELL_TURNED_POLYMER = ModBlocks.registerBlock("cell_turned_polymer",
            new CellTurnedPolymer(FabricBlockSettings.copy(Blocks.OBSIDIAN)));

    public static void register() {

    }

    private static Block registerBlock(String name, Block entry) {
        Registry.register(Registry.ITEM, new Identifier("fabrictest", name),
                new BlockItem(entry, new Item.Settings().group(ItemGroup.MISC)));
        return Registry.register(Registry.BLOCK, new Identifier("fabrictest", name), entry);
    }
}
