package fabrictest.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class ModCommands {
    public static void register(){
        CommandRegistrationCallback.EVENT.register((dispatcher,registryAccess,environment)-> dispatcher.register(LiteralArgumentBuilder.<ServerCommandSource>literal("foo").executes(context -> {
            context.getSource().sendFeedback(Text.literal("Called /foo with no arguments"),false);
            return 1;
        })));
    }
}
