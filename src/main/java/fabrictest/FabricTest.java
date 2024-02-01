package fabrictest;

import fabrictest.commands.ModCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fabrictest.blocks.ModBlocks;
import fabrictest.entities.ModEntities;
import fabrictest.items.ModItems;
import fabrictest.world.behavior.DispenserBehaviors;
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
		DispenserBehaviors.registerBehaviors();
		ModCommands.register();
	}
}