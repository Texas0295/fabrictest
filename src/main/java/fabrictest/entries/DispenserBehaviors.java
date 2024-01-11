package fabrictest.entries;

import fabrictest.items.ModItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class DispenserBehaviors {
    public static void registerBehaviors() {
        DispenserBlock.registerBehavior(ModItems.CELLS, new ProjectileDispenserBehavior() {

            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack itemStack) {
                return Util.make(new CellEntity(world, position.getX(), position.getY(), position.getZ()),
                        entity -> entity.setItem(itemStack));
            }

        });
    }
}
