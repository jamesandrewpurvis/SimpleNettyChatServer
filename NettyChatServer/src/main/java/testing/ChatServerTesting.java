package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import application.Startup;

public class ChatServerTesting {

	@Test
	public void testIP()
	{
		assertNotEquals(Startup.returnInstance(), null);
	}
	
	@Test
	public void TestPort()
	{
		assertNotEquals(Startup.returnInstance().returnPort(), 0);
	}
	
	@Test
	public void TestBootStrap()
	{
		assertNotEquals(Startup.returnInstance().returnBootStrap(), null);
		assertNotEquals(Startup.returnInstance().isListening(), false);
	}

}
