package fabrictest.blocks;

import fabrictest.FabricTest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.MutableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UnknownMachine extends Block {
    private static final BooleanProperty USING = BooleanProperty.of("using");

    public UnknownMachine(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(USING, false));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(USING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
            BlockHitResult hit) {
        FabricTest.MOD_LOGGER.info("entry");
        if (!world.isClient) {
            FabricTest.MOD_LOGGER.info(String.valueOf(state.get(USING)));
            if (!state.get(USING)) {
                player.sendMessage(MutableText.of(new LiteralTextContent("boot up,welcome")));
                world.setBlockState(pos, state.with(USING, true));
            } else {
                player.sendMessage(
                        MutableText.of(new LiteralTextContent("machine is using, now shutdown the machine")));
                world.setBlockState(pos, state.with(USING, false));
            }
        }
        return ActionResult.SUCCESS;
    }

}
