package hibi.aestheticsfix;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Init implements ClientModInitializer {

	public static final SoundEvent REDSTONE_SPARK = new SoundEvent(new Identifier("aestheticsfix", "redstone_spark"));
	public static final SoundEvent REPEATER_HUM = new SoundEvent(new Identifier("aestheticsfix", "repeater_hum"));
	public static final SoundEvent REPEATER_LOCKED = new SoundEvent(new Identifier("aestheticsfix", "repeater_locked"));
	public static final SoundEvent COMPARATOR_COMPARE = new SoundEvent(new Identifier("aestheticsfix", "comparator_compare"));
	public static final SoundEvent COMPARATOR_SUBTRACT = new SoundEvent(new Identifier("aestheticsfix", "comparator_subtract"));
	public static final SoundEvent SOUL_WHISPER = new SoundEvent(new Identifier("aestheticsfix", "soul_whisper"));

	@Override
	public void onInitializeClient() {
	}
}
