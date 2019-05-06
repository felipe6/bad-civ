package mainBoi;
import java.awt.Graphics;

public class Building extends GameObject{

	public Building(int x, int y, ID id) {
		super(x,y,id, true);
		
	}
	
	public void tick() {
		
		MoveToHome();
	}
	
	public void render(Graphics g) {
		
	}
	
}
