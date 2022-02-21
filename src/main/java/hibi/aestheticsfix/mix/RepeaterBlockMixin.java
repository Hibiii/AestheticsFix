package hibi.aestheticsfix.mix;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import hibi.aestheticsfix.Init;
import net.minecraft.block.BlockState;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(RepeaterBlock.class)
public class RepeaterBlockMixin {
	@Inject(
		at = @At("HEAD"),
		method = "randomDisplayTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V"
	)
	private void displayTick(BlockState state, World world, BlockPos pos, Random random, CallbackInfo info) {
		if(state.get(Properties.POWERED) && random.nextInt(24) == 0) {
			if(state.get(Properties.LOCKED))
				world.playSound(pos.getX(), pos.getY(), pos.getZ(), Init.REPEATER_LOCKED, SoundCategory.BLOCKS, 0.1f, 1.0f, true);
			else
				world.playSound(pos.getX(), pos.getY(), pos.getZ(), Init.REPEATER_HUM, SoundCategory.BLOCKS, 0.1f, 1.0f, true);
		}
	}
}
