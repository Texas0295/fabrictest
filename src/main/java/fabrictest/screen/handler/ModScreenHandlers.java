package fabrictest.screen.handler;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlers {
    public static final ScreenHandlerType<UnknownMachineScreenHandler> UNKNOWN_MACHINE_SCREEN_HANDLER = Registry
            .register(Registry.SCREEN_HANDLER, new Identifier("fabrictest", "unknown_machine"),
                    new ScreenHandlerType<>(UnknownMachineScreenHandler::new));

    public static void register() {
    }
}
