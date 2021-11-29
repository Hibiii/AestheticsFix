package hibi.aestheticsfix.mix;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import hibi.aestheticsfix.EffectDelegate;
import hibi.aestheticsfix.Effects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(Block.class)
public class BlockMixin {
	@Inject(
		at = @At("HEAD"),
		method = "randomDisplayTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V"
	)
	private void init(BlockState state, World world, BlockPos pos, Random random, CallbackInfo info) {
		EffectDelegate delegate = Effects.get(state.getBlock());
		if(delegate != null) delegate.displayTick(state, world, pos, random);
	}
}
