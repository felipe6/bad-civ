package mainBoi;
import java.awt.Graphics;

import playerInfo.Player;

public class Building extends GameObject{

	public Building(int x, int y, ID id, Player owner) {
		super(x, y, id, true, owner);
		
	}
	
	public void tick() {
		
		MoveToHome();
	}
	
	public void render(Graphics g) {
		
	}
	
}
