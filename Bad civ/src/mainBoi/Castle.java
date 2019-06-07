package mainBoi;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import input.MouseInput;
import playerInfo.Player;

public class Castle extends Building{

	public int defense;
	public int citizens;
	public Soldier garrison = null;
	
	public Castle(int x, int y, ID id, Player owner) {
		super (x, y, id, owner);
		this.defense = 10;
		this.citizens = 1;
	}
	
	public void calcDefense() {
		defense = citizens * 10;
		if (garrison != null) {
			
		}
	}
	
	
	

	@Override
	public void tick() {
	
		setHome();
		
	}

	@Override
	public void render(Graphics g) {
		id.image.render(g, x, y);
		// TODO Auto-generated method stub
		
	}
	
}
