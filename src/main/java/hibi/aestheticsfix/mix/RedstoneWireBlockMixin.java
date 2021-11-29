package hibi.aestheticsfix.mix;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import hibi.aestheticsfix.Init;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(RedstoneWireBlock.class)
public class RedstoneWireBlockMixin {
	@Inject(
		at = @At("TAIL"),
		method = "randomDisplayTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V"
	)
	private void displayTick(BlockState state, World world, BlockPos pos, Random random, CallbackInfo info) {
		if(state.get(Properties.POWER) > 1 && random.nextInt(1500) == 0)
		world.playSound(pos.getX(), pos.getY(), pos.getZ(), Init.REDSTONE_SPARK, SoundCategory.BLOCKS, state.get(Properties.POWER) / 15f, 1.0f, true);
	}
}
