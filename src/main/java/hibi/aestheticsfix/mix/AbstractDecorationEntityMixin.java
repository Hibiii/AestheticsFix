package hibi.aestheticsfix.mix;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.util.math.BlockPos;

@Mixin(AbstractDecorationEntity.class)
public class AbstractDecorationEntityMixin {
	@Shadow
	protected BlockPos attachmentPos;

	@Inject(
		at = @At("HEAD"),
		method = "tick")
	protected void tick(CallbackInfo info) {
	}
}
