package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Startup;

class ChatServerTesting {

	@Test
	void testIP()
	{
		assertNotEquals(Startup.returnInstance(), null);
	}
	
	@Test
	void TestPort()
	{
		assertNotEquals(Startup.returnInstance().returnPort(), 0);
	}
	
	@Test
	void TestBootStrap()
	{
		assertNotEquals(Startup.returnInstance().returnBootStrap(), null);
		assertNotEquals(Startup.returnInstance().returnBootStrap(), false);
	}

}
