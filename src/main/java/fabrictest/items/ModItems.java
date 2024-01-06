package fabrictest.items;

import fabrictest.blocks.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item CELLS = new Cells(new Item.Settings().group(ItemGroup.MATERIALS));
    public static void register(){
        Registry.register(Registry.ITEM,new Identifier("fabrictest","cells"),CELLS);
        Registry.register(Registry.ITEM,new Identifier("fabrictest","bizarre_polymer"), new BlockItem(ModBlocks.BIZARRE_POLYMER,new FabricItemSettings()));
    }
}
