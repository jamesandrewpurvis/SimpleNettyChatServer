import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class NettyChannelIntializer extends ChannelInitializer<SocketChannel>
{
	
	private ChatServer mChatServerInstance = null;
	
	public NettyChannelIntializer(ChatServer instance)
	{
		this.mChatServerInstance = instance;
	}
	
	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception 
	{
		ChannelPipeline mPipeline = socketChannel.pipeline();
		
		mPipeline.addLast("Encoder", new Encoder());
		mPipeline.addLast("Decoder", new Decoder());
		mPipeline.addLast("handler", new ConnectionHandler());
		
		
	}

}
