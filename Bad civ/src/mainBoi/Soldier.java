package mainBoi;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import input.KeyInput;
import input.MouseInput;

public class Soldier extends GameObject{

    public Soldier(int x, int y, ID id){
        super(x, y, id, true);
    }

    public void tick(){
    	if (MouseInput.wasPressed(MouseEvent.BUTTON1)) {
    		System.out.println("Clicked: " + MouseInput.x + "  " + MouseInput.y);
    		int[] newHome = findHome(MouseInput.x, MouseInput.y);
    		setHome(newHome[0], newHome[1]);

    		System.out.println("Found: " + newHome[0] + "  " + newHome[1]);
    		System.out.println("Tile chords: " + Game.handler.map.tiles[newHome[0]][newHome[1]].x + "  " + Game.handler.map.tiles[newHome[0]][newHome[1]].y);
    	}
    	if (KeyInput.wasPressed(KeyEvent.VK_0)) {
    		setHome(homeX + 1, homeY);
    	}
    	
    	MoveToHome();
    }
    
    public void render(Graphics g){
    	id.image.render(g, x, y);
        //g.setColor(Color.red);
        //g.fillRect(x, y, 32, 32);
    }
}