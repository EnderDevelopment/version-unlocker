package com.enderversion.versionjoin.mixin;

import com.enderversion.versionjoin.VersionJoinClient;
import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Rewrites the protocol version stored in the handshake packet that the client
 * sends to a server when connecting.
 *
 * <p>This is how the client advertises which protocol it speaks. Changing it alone
 * does not translate game data between versions; see the README for the real,
 * protocol-translating solution.</p>
 */
@Mixin(HandshakeC2SPacket.class)
public abstract class HandshakeC2SPacketMixin {

    /**
     * Overwrites the first constructor argument (the reported protocol version)
     * with the value from the config before it is stored in the packet.
     */
    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            ordinal = 0,
            argsOnly = true
    )
    private int versionjoin$overrideProtocolVersion(int protocolVersion) {
        if (VersionJoinClient.CONFIG != null) {
            return VersionJoinClient.CONFIG.protocolVersion;
        }
        return protocolVersion;
    }
}
