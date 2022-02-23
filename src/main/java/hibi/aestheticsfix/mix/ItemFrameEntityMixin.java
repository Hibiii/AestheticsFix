package hibi.aestheticsfix.mix;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import hibi.aestheticsfix.Init;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;

@Mixin(ItemFrameEntity.class)
public class ItemFrameEntityMixin extends AbstractDecorationEntityMixin {

	@Shadow
	public ItemStack getHeldItemStack() {
		return null;
	}

	@Override
	protected void tick(CallbackInfo info) {
		if(this.getHeldItemStack().getItem() != Items.CLOCK)
			return;
		long tick = ((ItemFrameEntity)(Object)this).world.getTime();
		if(tick % 20 == 0) {
			if(tick % 40 == 0) {
				((ItemFrameEntity)(Object)this).world.playSound(this.attachmentPos.getX(), this.attachmentPos.getY(), this.attachmentPos.getZ(), Init.CLOCK_TICK_UP, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
				return;
			}
			((ItemFrameEntity)(Object)this).world.playSound(this.attachmentPos.getX(), this.attachmentPos.getY(), this.attachmentPos.getZ(), Init.CLOCK_TICK_DOWN, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
			return;
		}
	}
}
