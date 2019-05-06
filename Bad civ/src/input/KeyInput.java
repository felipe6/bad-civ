package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private static final boolean[] keys = new boolean[256];
	private static final boolean[] lastKeys = new boolean[256];

	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public static boolean isKeyDown (int key) {
		return keys[key];
	}
	
	public static void update() {
		for (int i = 0; i < keys.length; i++) {
			lastKeys[i] = keys[i];
		}
	}
	
	public static boolean wasPressed(int keyCode) {
		return isKeyDown (keyCode) && !lastKeys[keyCode];
	}
	
}