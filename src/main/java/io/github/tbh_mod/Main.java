package io.github.tbh_mod;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Tbh Mod");
	public static final String MOD_ID = "tbh_mod";


	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Initializing Tbh Mod!", mod.metadata().name());
		TbhEntity.registerTbhEntityAttributes();
		TbhRegistry.registerItems();
	}
}