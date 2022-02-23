package hibi.aestheticsfix.mix;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import hibi.aestheticsfix.Init;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin({
	CampfireBlock.class,
	TorchBlock.class,
	WallTorchBlock.class})
public class SoulfulBlockMixin {
	@Inject(
		at = @At("HEAD"),
		method = "randomDisplayTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V"
	)
	protected void displayTick(BlockState state, World world, BlockPos pos, Random random, CallbackInfo info) {
		if((state.getBlock() == Blocks.SOUL_TORCH || state.getBlock() == Blocks.SOUL_WALL_TORCH || state.getBlock() == Blocks.SOUL_CAMPFIRE) && random.nextInt(500) == 0)
			world.playSound(pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d, Init.SOUL_WHISPER, SoundCategory.AMBIENT, 1.0f, 1.0f, true);
	}
}
