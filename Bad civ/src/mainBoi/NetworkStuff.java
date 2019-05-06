package mainBoi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetworkStuff {

	private String ip = "localHost";
	private int port = 22222;
	private Scanner scanner = new Scanner(System.in);
	
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	private ServerSocket serverSocket;
	public boolean accepted = false;
	
	public NetworkStuff() {
		System.out.println("Please input the IP: ");
		ip = scanner.nextLine();
		System.out.println("Please input the Port: ");
		port = scanner.nextInt();
		while (port < 1 || port > 65535) {
			System.out.println("The port you entered is invalid, so make it another: ");
			port = scanner.nextInt();
		}
		
		
	}
	
	public void listenForSeverRequest() {
		Socket socket = null;
		try {
			socket = serverSocket.accept();
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			accepted = true;
			System.out.println("Client has joined");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}