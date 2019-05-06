package mapStuff;

import java.awt.event.MouseEvent;

import input.MouseInput;
import mainBoi.Game;
import mainBoi.Handler;

public class MapControlHandler {
	
	static int moveX = 0, moveY = 0;
	static int lastMoveX = 0, lastMoveY = 0;
	
	public static void tick() {
		Tile[][] tiles = Game.handler.map.tiles;
		
		moveX = MouseInput.x;
		moveY = MouseInput.y;
		
		if (MouseInput.isDown(MouseEvent.BUTTON3)) {
			System.out.println("x: " + moveX + " lastX: " + lastMoveX);
			
			if (moveX != lastMoveX || moveY != lastMoveY) {
				int difX = moveX - lastMoveX;
				int difY = moveY - lastMoveY;
								
				for (int i = 0; i < tiles.length; i++) {
		    		for (int t = 0; t < tiles[i].length; t++) {
		    			tiles[i][t].x += difX;
		    			tiles[i][t].y += difY;
		    		}
		    	}
			}
		}
		
		lastMoveX = moveX;
		lastMoveY = moveY;
	}
}