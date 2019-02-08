package com.teamacronymcoders.epicurious.modules.theoneprobe;

import com.teamacronymcoders.epicurious.Epicurious;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.function.Function;

public class TOPCompat implements Function<ITheOneProbe, Void> {

    public static ITheOneProbe probe;

    @Override
    public Void apply(ITheOneProbe iTheOneProbe) {
        probe = iTheOneProbe;
        Epicurious.logger.info("Enabled Support for The One Probe");
        probe.registerProvider(new IProbeInfoProvider() {
            @Override
            public String getID() {
                return "epicurious:compost";
            }

            @Override
            public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
                if (blockState.getBlock() instanceof TOPInfoProvider) {
                    TOPInfoProvider provider = (TOPInfoProvider) blockState.getBlock();
                    provider.addProbeInfo(mode, probeInfo, player, world, blockState, data);
                }
            }
        });
        return null;
    }
}
