package fabrictest.screens;

import fabrictest.screen.handler.ModScreenHandlers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class ModScreens {

    public static void register() {
        HandledScreens.register(ModScreenHandlers.UNKNOWN_MACHINE_SCREEN_HANDLER, UnknownMachineScreen::new);
    }
}
