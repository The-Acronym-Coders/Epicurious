package com.teamacronymcoders.epicurious.modules.compats.hwyla;

import com.teamacronymcoders.epicurious.modules.content.compost.BlockCompostBin;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class HwylaCompatProvider implements IWailaDataProvider {
    @Nonnull
    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> tooltip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        IBlockState state = accessor.getBlockState();
        if (config.getConfig("epicurious.compost")) {
            if (accessor.getBlock() instanceof BlockCompostBin) {
                tooltip.add("Compost: " + state.getValue(BlockCompostBin.Compost_Amount));
            }
        }
        return tooltip;
    }
}
