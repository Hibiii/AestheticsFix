package hibi.aestheticsfix;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.block.enums.ComparatorMode;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.LightType;

public class Effects {

	public static EffectDelegate get(Block block) {
		return db.get(block);
	}

	private static final Map<Block,EffectDelegate> db;
	
	private Effects() {}

	static {
		db = new HashMap<Block,EffectDelegate>();
		db.put(Blocks.AMETHYST_BLOCK, (bs, w, p, r) -> {
			if(r.nextInt(100) == 0)
			w.playSound(p.getX() + 0.5d, p.getY() + 0.5d, p.getZ() + 0.5d, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
		});
		db.put(Blocks.COMPARATOR, (bs, w, p, r) -> {
			if(bs.get(Properties.POWERED) && r.nextInt(24) == 0) {
				if(bs.get(ComparatorBlock.MODE) == ComparatorMode.SUBTRACT)
					w.playSound(p.getX(), p.getY(), p.getZ(), Init.COMPARATOR_SUBTRACT, SoundCategory.BLOCKS, 0.1f, 1.0f, true);
				else
					w.playSound(p.getX(), p.getY(), p.getZ(), Init.COMPARATOR_COMPARE, SoundCategory.BLOCKS, 0.1f, 1.0f, true);
			}
		});
		db.put(Blocks.ICE, (bs, w, p, r) -> {
			if(r.nextInt(4) != 0) return;
			if(w.getLightLevel(LightType.BLOCK, p) > 11 - bs.getOpacity(w, p)) {
				Direction dir = Direction.random(r);
				BlockPos pos2 = p.offset(dir);
				if(bs.isOpaque() && w.getBlockState(pos2).isSideSolidFullSquare(w, pos2, dir.getOpposite()))
					return;
				double xOff = dir.getOffsetX() == 0? r.nextDouble() : 0.5 + (double)dir.getOffsetX() * 0.6;
				double yOff = dir.getOffsetY() == 0? r.nextDouble() : 0.5 + (double)dir.getOffsetY() * 0.6;
				double zOff = dir.getOffsetZ() == 0? r.nextDouble() : 0.5 + (double)dir.getOffsetZ() * 0.6;
				w.addParticle(ParticleTypes.DRIPPING_WATER, p.getX() + xOff, p.getY() + yOff, p.getZ() + zOff, 0d, 0d, 0d);
			}
		});
		db.put(Blocks.SOUL_SAND, (bs, w, p, r) -> {
			if(w.isAir(p.up()) && r.nextInt(200) == 0) {
				double x = p.getX() + r.nextDouble();
				double y = p.getY() + 1d;
				double z = p.getZ() + r.nextDouble();
				w.addParticle(ParticleTypes.SOUL, x, y, z, 0d, 0.005d + r.nextDouble() * 0.025d, 0d);
				w.playSound(x, y, z, SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
			};
		});
		db.put(Blocks.CRIMSON_ROOTS, (bs, w, p, r) -> {
			if(r.nextInt(10) == 0)
				w.addParticle(ParticleTypes.CRIMSON_SPORE, p.getX() + 0.5d, p.getY() + 0.5d, p.getZ() + 0.5d, 0d, 0d, 0d);
		});
		db.put(Blocks.WARPED_ROOTS, (bs, w, p, r) -> {
			if(r.nextInt(10) == 0)
				w.addParticle(ParticleTypes.WARPED_SPORE, p.getX() + 0.5d, p.getY() + 0.5d, p.getZ() + 0.5d, 0d, 0d, 0d);
		});
		db.put(Blocks.REDSTONE_LAMP, (bs, w, p, r) -> {
			if(bs.get(Properties.LIT)) {
				if(r.nextInt(12) == 0)
					w.playSound(p.getX() + 0.5d, p.getY() + 0.5d, p.getZ() + 0.5d, Init.LAMP_HUM, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
			}
		});
	}
}
