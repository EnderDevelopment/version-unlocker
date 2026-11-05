package com.enderversion.versionjoin.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Holds the user-configurable values that control what version the client reports.
 *
 * <p>Because this is a client mod, the config lives in {@code config/versionjoin.json}
 * next to the Minecraft run directory.</p>
 */
public final class VersionJoinConfig {

    /** The version text reported to the server list and the handshake. */
    public String serverVersion = "1.21.1";

    /** The protocol number reported in the handshake. */
    public int protocolVersion = 767;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static VersionJoinConfig load(Path configFile) {
        VersionJoinConfig config;
        if (Files.exists(configFile)) {
            try {
                config = GSON.fromJson(Files.readString(configFile), VersionJoinConfig.class);
            } catch (IOException e) {
                config = new VersionJoinConfig();
            }
        } else {
            config = new VersionJoinConfig();
        }
        if (config == null) {
            config = new VersionJoinConfig();
        }
        save(configFile, config);
        return config;
    }

    public static void save(Path configFile, VersionJoinConfig config) {
        try {
            Files.createDirectories(configFile.getParent());
            Files.writeString(configFile, GSON.toJson(config));
        } catch (IOException e) {
            // Never crash the client because the config could not be written.
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
