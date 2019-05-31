package mainBoi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import Rendering.textures.Button;
import input.MouseInput;
import utilities.managers.Fonts;

public class Menu {
	
	private final Button[] options;
	private int currentSelection;
	
	public Menu() {
		options = new Button[5];
		options[0] = new Button("Play", 200 + 0,
				new Font("Ariel", Font.PLAIN, 32), new Font("Ariel", Font.BOLD, 48), Color.WHITE, Color.YELLOW);
		options[1] = new Button("Multiplayer", 200 + 60 * 1,
				new Font("Ariel", Font.PLAIN, 32), new Font("Ariel", Font.BOLD, 48), Color.WHITE, Color.YELLOW);
		options[2] = new Button("Select Map", 200 + 60 * 2,
				new Font("Ariel", Font.PLAIN, 32), new Font("Ariel", Font.BOLD, 48), Color.WHITE, Color.YELLOW);
		options[3] = new Button("Options", 200 + 60 * 3,
				new Font("Ariel", Font.PLAIN, 32), new Font("Ariel", Font.BOLD, 48), Color.WHITE, Color.YELLOW);
		options[4] = new Button("Exit", 200 + 60 * 4,
				new Font("Ariel", Font.PLAIN, 32), new Font("Ariel", Font.BOLD, 48), Color.WHITE, Color.YELLOW);
	}
	
	public void tick() {
		for (int i = 0; i < options.length; i++) {
			if (options[i].intersects(new Rectangle(MouseInput.x, MouseInput.y, 1, 1))) {
				currentSelection = i;
				if (MouseInput.isDown(MouseEvent.BUTTON1)) {
					select();
				}
			}
		}
	}
	
	private void select() {
		switch(currentSelection) {
			case 0:
				Game.instance.setState(States.PLAYING.ordinal());
				System.out.println("Selected Play");
				break;
			case 1:
				Game.instance.setState(States.MULTIPLAYER.ordinal());
				System.out.println("Selected Multiplayer Play");
				break;
			case 2:
				Game.instance.setState(States.LEVEL_SELECT.ordinal());
				System.out.println("Selected Level Picking");
				break;
			case 3:
				Game.instance.setState(States.OPTIONS.ordinal());
				System.out.println("Selected Options");
				break;
			case 4:
				Game.instance.running = false;
				Game.window.frame.dispatchEvent(new WindowEvent(Game.window.frame, WindowEvent.WINDOW_CLOSING));
				break;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		Fonts.drawString(g, new Font("Ariel", Font.BOLD, 72), Color.ORANGE, Game.title, 80);
		
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection) {
				options[i].setSelected(true);
			}else {
				options[i].setSelected(false);
			}
			options[i].render(g);
		}
	}

}

enum States {
	MENU, PLAYING, MULTIPLAYER, OPTIONS, LEVEL_SELECT
}
