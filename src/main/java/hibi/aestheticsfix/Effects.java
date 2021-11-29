package hibi.aestheticsfix;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class Effects {

	public static EffectDelegate get(Block block) {
		return db.get(block);
	}

	private static final Map<Block,EffectDelegate> db;
	
	private Effects() {}

	static {
		db = new HashMap<Block,EffectDelegate>();
		db.put(Blocks.AMETHYST_BLOCK, (bs, w, p, r) -> {
			if(r.nextFloat() < 0.006)
			w.playSound(p.getX(), p.getY(), p.getZ(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
		});
		db.put(Blocks.SOUL_SAND, (bs, w, p, r) -> {
			if(w.isAir(p.up()) && r.nextFloat() < 0.008)
			w.addParticle(ParticleTypes.SOUL, p.getX() + r.nextDouble(), p.getY() + 1d, p.getZ() + r.nextDouble(), 0d, 0.005d + r.nextDouble() * 0.025d, 0d);
		});
	}
}
