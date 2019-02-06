package com.teamacronymcoders.epicurious.utils.network;

import com.teamacronymcoders.epicurious.common.content.compost.TileCompostBin;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class UpdateStateMessage implements IMessage, IMessageHandler<UpdateStateMessage, IMessage> {
    private int x;
    private int y;
    private int z;
    private int compost;

    public UpdateStateMessage() {}

    public UpdateStateMessage(int x, int y, int z, int compost) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.compost = compost;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.compost = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
        buf.writeInt(this.compost);
    }

    @Override
    public IMessage onMessage(UpdateStateMessage message, MessageContext ctx) {
        Minecraft.getMinecraft().addScheduledTask(() -> handle(message, ctx));
        return null;
    }

    private void handle(UpdateStateMessage message, MessageContext ctx) {
        if (FMLClientHandler.instance().getClient().world != null) {
            TileEntity te = FMLClientHandler.instance().getClient().world.getTileEntity(new BlockPos(message.x, message.y, message.z));
            if (te instanceof TileCompostBin) {
                TileCompostBin bin = (TileCompostBin) te;
                bin.setCompost(message.compost);
            }
        }
    }
}
