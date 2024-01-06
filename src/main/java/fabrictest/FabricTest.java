package fabrictest;

import fabrictest.blocks.ModBlocks;
import fabrictest.entries.ModEntities;
import fabrictest.items.ModItems;
import net.fabricmc.api.ModInitializer;

public class FabricTest implements ModInitializer {
	@Override
	public void onInitialize() {
		ModItems.register();
		ModEntities.register();
		ModBlocks.register();
	}
}