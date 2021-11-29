package hibi.aestheticsfix;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface EffectDelegate {
    public void displayTick(BlockState blockState, World world, BlockPos pos, Random random);
}
