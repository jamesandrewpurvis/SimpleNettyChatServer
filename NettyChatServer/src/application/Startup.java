package application;
import java.util.Scanner;

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
	}

}
