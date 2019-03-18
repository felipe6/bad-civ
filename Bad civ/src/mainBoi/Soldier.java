package mainBoi;
import java.awt.Color;
import java.awt.Graphics;

public class Soldier extends GameObject{

    public Soldier(int x, int y, ID id){
        super(x, y, id);
    }

    public void tick(){
    	setX(x+5);
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
    }
}