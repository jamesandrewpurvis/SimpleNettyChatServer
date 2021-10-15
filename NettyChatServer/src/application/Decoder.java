import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Decoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		
		System.out.println("Message from client[" + ctx.channel().localAddress() + "] -" );
		while(in.isReadable() == true)
		{
			System.out.print((char) in.readByte());
			System.out.flush();
		}
		
	}

}
