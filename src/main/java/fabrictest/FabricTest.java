package fabrictest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fabrictest.blocks.ModBlocks;
import fabrictest.entries.ModEntities;
import fabrictest.items.ModItems;
import fabrictest.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

public class FabricTest implements ModInitializer {
	public static final Logger MOD_LOGGER = LoggerFactory.getLogger("fabric");

	@Override
	public void onInitialize() {
		ModWorldGeneration.generate();
		ModItems.register();
		ModEntities.register();
		ModBlocks.register();
	}
}