package hibi.aestheticsfix;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;

public class Effects {

	public static EffectDelegate get(Block block) {
		return db.get(block);
	}

	private static final Map<Block,EffectDelegate> db;
	
	private Effects() {}

	static {
		db = new HashMap<Block,EffectDelegate>();
		db.put(Blocks.SOUL_SAND, (bs, w, p, r) -> {
			if(w.isAir(p.up()) && r.nextFloat() < 0.008)
			w.addParticle(ParticleTypes.SOUL, p.getX() + r.nextDouble(), p.getY() + 1d, p.getZ() + r.nextDouble(), 0d, 0.005d + r.nextDouble() * 0.025d, 0d);
		});
	}
}
