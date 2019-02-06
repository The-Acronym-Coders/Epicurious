package com.teamacronymcoders.epicurious.common.content.compost;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.utils.network.UpdateStateMessage;
import com.teamacronymcoders.survivalism.utils.network.SurvivalismPacketHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class TileCompostBin extends TileEntity {

    private int compost;

    public TileCompostBin() {}

    void addCompost(EntityPlayer player) {
        if (world.getBlockState(getPos()).getBlock() instanceof BlockCompostBin) {
            IBlockState state = world.getBlockState(getPos());
            compost = state.getValue(BlockCompostBin.compostAmount);
            if (!(compost > 10)) {
                compost += 1;
                state.withProperty(BlockCompostBin.compostAmount, compost);
                sendUpdatePacketClient();
            } else {
                state.withProperty(BlockCompostBin.compostAmount, 0);
                player.inventory.addItemStackToInventory(new ItemStack(ModItems.compost, MathHelper.getInt(world.rand, 1, 4)));
                sendUpdatePacketClient();
            }
        }
    }

    public void setCompost(int compost) {
        this.compost = compost;
    }

    private void sendUpdatePacketClient() {
        this.markDirty();
        this.compost = getWorld().getBlockState(getPos()).getValue(BlockCompostBin.compostAmount);
        getWorld().addBlockEvent(getPos(), this.getBlockType(), 1, this.compost);
        Epicurious.INSTANCE.getPacketHandler().sendToAllAround(new UpdateStateMessage(getPos().getX(), getPos().getY(), getPos().getZ(), this.compost), new NetworkRegistry.TargetPoint(this.world.provider.getDimension(), (double) this.getPos().getX(), (double) this.getPos().getY(), (double) this.getPos().getZ(), 128d));
        this.world.notifyNeighborsOfStateChange(getPos(), getBlockType(), true);
    }
}
