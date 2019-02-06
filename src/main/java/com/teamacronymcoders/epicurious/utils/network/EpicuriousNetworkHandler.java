package com.teamacronymcoders.epicurious.utils.network;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.survivalism.Survivalism;
import com.teamacronymcoders.survivalism.utils.network.SurvivalismPacketHandler;
import net.minecraftforge.fml.relauncher.Side;

public class EpicuriousNetworkHandler {
    private static int PacketID = 0;

    public EpicuriousNetworkHandler() {}

    public static int nextID() {
        return PacketID++;
    }

    public static void registerMessages() {
        Epicurious.INSTANCE.getPacketHandler().registerPacket(UpdateStateMessage.class, UpdateStateMessage.class, Side.CLIENT);
    }
}
