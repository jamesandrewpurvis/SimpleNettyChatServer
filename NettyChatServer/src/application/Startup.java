package application;
import java.util.Scanner;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class Startup {

	private static ChatServer mInstance = null;
	
	public static ChatServer returnInstance()
	{
		return mInstance;
	}
	
	public static void main(String[] args) {
		Scanner mScanner = new Scanner(System.in);
		System.out.println("Please enter a IP: ");
		String mIP = mScanner.next();
		System.out.println("Please enter a port: ");
		int mPort = mScanner.nextInt();
		mInstance = new ChatServer(mIP, mPort);
		
	
		JUnitCore mTestInstance = new JUnitCore();
		mTestInstance.addListener(new TextListener(System.out));
		mTestInstance.run(testing.ChatServerTesting.class);
		
	}

}
