package fabrictest.items;

import fabrictest.entries.CellEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Cells extends Item {
    public Cells(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient){
            CellEntity entry = new CellEntity(world,user);
            entry.setItem(itemStack);
            entry.setVelocity(user,user.getPitch(),user.getYaw(),0.0f,1.5f,0f);
            world.spawnEntity(entry);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public boolean isFireproof() {
        return true;
    }
}
