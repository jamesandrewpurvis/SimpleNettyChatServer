package application;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ConnectionHandler extends SimpleChannelInboundHandler<Byte[]> {

	@Override
	public void channelRegistered(ChannelHandlerContext ctx)
	{
		System.out.println("A client with id:  " + ctx.channel().id() + "has connected!");
	}
	
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Byte[] msg) throws Exception {
		System.out.println("Data received!");
		
	}

}
