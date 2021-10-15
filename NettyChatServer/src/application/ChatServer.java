package application;
import java.net.InetSocketAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class ChatServer
{
	
	private int mPort;
	private EventLoopGroup mWorkerGroup;
	private EventLoopGroup mBossGroup;
	private ServerBootstrap mBootStrap;
	final private static Logger mLogger = LogManager.getLogger(ChatServer.class);
	private String mIP;
	private boolean mIsListening;
	
	public int returnPort()
	{
		return mPort;
	}
	
	public String returnIP()
	{
		return mIP;
	}
	
	public ServerBootstrap returnBootStrap()
	{
		return mBootStrap;
	}
	
	public boolean isListening()
	{
		return mIsListening;
	}
	
	public ChatServer(String IP, int port)
	{
		mPort = port;
		mIP = IP;
		try
		{
		  mWorkerGroup = new NioEventLoopGroup();
		  mBossGroup = new NioEventLoopGroup();
		  mBootStrap = new ServerBootstrap();
		  mBootStrap.group(mBossGroup, mWorkerGroup).channel(NioServerSocketChannel.class)
		  .childHandler(new NettyChannelIntializer(this));
		  bind(mIP, port);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	
	private void bind(String ip, int port)
	{
	    try
	    {
	         this.mBootStrap.bind(new InetSocketAddress(ip, port)).addListener(objectFuture -> {
	        	 if (!objectFuture.isSuccess())
	        	 {
	        		 System.out.println("Failed to start server.");
	        		 mIsListening = false;
	        	 }
	        	 else
	        	 {
	        		 System.out.println("Server listening on " + ip + ":" + port);
	        		 mIsListening= true;
	        	 }
	         });
	    	
	    }
	    catch(Exception ex)
	    {
	    	System.out.println(ex.getMessage());
	    }
	}
}
