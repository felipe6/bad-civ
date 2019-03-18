package mapStuff;

import java.awt.Graphics;

import mainBoi.Game;
import mainBoi.GameObject;
import mainBoi.ID;

public abstract class BaseMap{

	private Tile[][] tiles;
	public int gridSize;
	private final int yOffSet = 15;
	private final int xOffSet = 8;

	
	public BaseMap(int gridSize) {
		this.gridSize = gridSize;
		tiles = new Tile[gridSize][gridSize];
	}
	
	public abstract void mapGenerator();
	
    public void render(Graphics g) {
    	for (int i = 0; i < gridSize; i++) {
    		for (int j = 0; j < gridSize; j++) {
    	    	if (tiles[i][j] != null) {
    	    		tiles[i][j].render(g);
    	    	}
        	}
    	}
    }
    
    public void insertTile(ID id, int x, int y) {
    	int t = (64 - xOffSet) / 2;
    	int gridWidth = gridSize * (64 - xOffSet);
    	int gridHeight = gridSize * (64 - yOffSet);
    	int wallDx = ((Game.WIDTH - gridWidth) / 2) - 25;
    	int wallDy = ((Game.HEIGHT - gridHeight) / 2) - 18;

    	tiles[x][y] = new Tile(((x) * (64 - xOffSet)) + wallDx + ((y % 2) * t), ((y) * (64 - yOffSet)) + wallDy, id);
    }
	
}
