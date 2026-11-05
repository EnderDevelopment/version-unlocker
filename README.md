# VersionJoin

VersionJoin is a Fabric client mod for Minecraft 1.21.1 that lets you control the version information your client reports to servers during connection. This mod rewrites the protocol version in the handshake packet, allowing you to change how your client appears to servers. It is important to understand that this mod only changes the reported version and does not translate game data between versions. For actual cross-version play, you need a protocol translator like ViaFabric.

## Install

1. Install the **Fabric Loader** for **1.21.1** using the official Fabric installer.
2. Download the **Fabric API** jar for Minecraft 1.21.1 from Modrinth or CurseForge and place it in your `mods` folder.
3. Place the `versionjoin-1.0.0.jar` file in the same `mods` folder.
4. Launch Minecraft using the Fabric profile.

## Use

1. Start Minecraft once with the mod installed to generate the configuration file.
2. Navigate to the `config` folder inside your Minecraft directory and open `versionjoin.json`.
3. Edit the `protocolVersion` value to the protocol number of the version you want to report. For example, use 763 for Minecraft 1.20.1, 758 for 1.18.2, or 340 for 1.12.2.
4. Adjust the `serverVersion` field to display the version name you want to show.
5. Save the file and restart Minecraft for changes to take effect.

**Important**: This mod only changes the reported version. If the server uses a genuinely different protocol, your connection may fail or experience issues. For true cross-version compatibility, install ViaFabric alongside this mod.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/6fe6e055-7d81-4b74-801d-4e77c089312d?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=6fe6e055-7d81-4b74-801d-4e77c089312d
