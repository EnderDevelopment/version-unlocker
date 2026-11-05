package com.enderversion.versionjoin;

import com.enderversion.versionjoin.config.VersionJoinConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

/**
 * Client-side entrypoint. Loads the configuration once at startup so the mixins
 * can read which version the client should report.
 */
public class VersionJoinClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("versionjoin");
    public static final String MOD_ID = "versionjoin";

    public static VersionJoinConfig CONFIG;

    @Override
    public void onInitializeClient() {
        Path configFile = FabricLoader.getInstance().getConfigDir().resolve("versionjoin.json");
        CONFIG = VersionJoinConfig.load(configFile);
        LOGGER.info("[VersionJoin] Loaded config: server version '{}' protocol {}",
                CONFIG.serverVersion, CONFIG.protocolVersion);
    }
}
