package input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{
	
	private static final boolean[] buttons = new boolean[10];
	private static final boolean[] lastButtons = new boolean[10];
	public static int x, y;
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Button: " + e.getButton());
		buttons[e.getButton()] = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	public static void update() {
		for (int i = 0; i < buttons.length; i++) {
			lastButtons[i] = buttons[i];
		}
	}
	
	public static boolean isDown(int button) {
		return buttons[button];
	}
	
	public static boolean wasPressed(int button) {
		return isDown(button) && !lastButtons[button];
	}
	
	public static boolean wasReleased(int button) {
		return !isDown(button) && lastButtons[button];
	}
}