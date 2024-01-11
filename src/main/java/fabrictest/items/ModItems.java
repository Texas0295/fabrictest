package fabrictest.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item CELLS = new Cells(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item CELL_TURNED_POLYMER_INGOT = new CellTurnedPolymerIngot(
            new Item.Settings().group(ItemGroup.MATERIALS));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("fabrictest", "cells"), CELLS);
        Registry.register(Registry.ITEM, new Identifier("fabrictest", "cell_turned_polymer_ingot"),
                CELL_TURNED_POLYMER_INGOT);
    }
}
