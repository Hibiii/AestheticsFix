package hibi.aestheticsfix;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Init implements ClientModInitializer {

	public static final SoundEvent REDSTONE_SPARK = new SoundEvent(new Identifier("aestheticsfix", "redstone_spark"));
	public static final SoundEvent SOUL_WHISPER = new SoundEvent(new Identifier("aestheticsfix", "soul_whisper"));

	@Override
	public void onInitializeClient() {
	}
}
