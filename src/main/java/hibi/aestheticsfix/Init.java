package hibi.aestheticsfix;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Init implements ClientModInitializer {

	public static final SoundEvent REDSTONE_SPARK = new SoundEvent(new Identifier("aestheticsfix", "redstone_spark"));

	@Override
	public void onInitializeClient() {
	}
}
