package mainBoi;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

import input.KeyInput;
import mapStuff.Tile;

public class NetworkStuff {

	private String ip = "localHost";
	private int port = 22222;
	private Scanner scanner = new Scanner(System.in);

	private Socket socket;
	private ObjectOutputStream dos;
	private ObjectInputStream dis;

	private ServerSocket serverSocket;
	public boolean accepted = false;
	private boolean unableToCommunicate = false;
	private int errors = 0;
	private boolean yourTurn = false;
	private boolean firstPassThrough = false;
	private boolean isServer;

	public NetworkStuff() {
		System.out.println("Please input the IP: ");
		// ip = scanner.nextLine();
		System.out.println("Please input the Port: ");
		// port = scanner.nextInt();
		while (port < 1 || port > 65535) {
			System.out.println("The port you entered is invalid, so make it another: ");
			port = scanner.nextInt();
		}

		if (!connect()) {
			InitializeServer();
		}
	}

	public void tick() {
		if (isServer && !accepted) {
			System.out.println("Listening for additional player");
			listenForServerRequest();
		}

		if (yourTurn && KeyInput.wasPressed(KeyEvent.VK_1)) {
			try {
				dos.writeObject(Game.handler.object);
				yourTurn = false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (errors > 10)
			unableToCommunicate = true;

		if (!yourTurn && !unableToCommunicate) {
			try {
				//Game.instance.render();
				if (dis.available() != 0) {
					System.out.println("reading object");
					Game.handler.object = (LinkedList<GameObject>) dis.readObject();
					yourTurn = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
				errors++;
			}
		}
	}

	public void listenForServerRequest() {
		Socket socket = null;
		try {
			socket = serverSocket.accept();
			dos = new ObjectOutputStream(socket.getOutputStream());
			dis = new ObjectInputStream(socket.getInputStream());
			accepted = true;

			System.out.println("Client has joined");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean connect() {
		try {
			socket = new Socket(ip, port);
			dos = new ObjectOutputStream(socket.getOutputStream());
			dis = new ObjectInputStream(socket.getInputStream());
			accepted = true;
			firstPassThrough = true;
		} catch (Exception e) {
			System.out.println("Unable to connect to address: " + ip + ": " + "| Starting server");
			return false;
		}
		System.out.println("Successfully connected to server");
		return true;
	}

	private void InitializeServer() {
		try {
			serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
		} catch (Exception e) {
			e.printStackTrace();
		}
		isServer = true;
		yourTurn = true;
	}
}