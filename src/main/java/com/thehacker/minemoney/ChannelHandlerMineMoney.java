package com.thehacker.minemoney;

import net.minecraft.client.*;
import net.minecraft.network.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class ChannelHandlerMineMoney extends FMLIndexedMessageToMessageCodec<IPacketMineMoney> {

	@Override
	public void encodeInto(ChannelHandlerContext ctx, IPacketMineMoney packet, ByteBuf data) throws Exception {
		packet.writeBytes(data);
    }

    @Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data, IPacketMineMoney packet) {
	    packet.readBytes(data);
	    switch (FMLCommonHandler.instance().getEffectiveSide()) {
	        case CLIENT:
	            packet.executeClient(Minecraft.getMinecraft().thePlayer);
	            break;
	        case SERVER:
	            INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
	            packet.executeServer(((NetHandlerPlayServer) netHandler).playerEntity);
	            break;
	    }
    }

}
