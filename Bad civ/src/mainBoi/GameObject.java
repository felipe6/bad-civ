package mainBoi;
import java.awt.Graphics;
import java.io.Serializable;

import mapStuff.BaseMap;
import mapStuff.Tile;
import playerInfo.Player;
public abstract class GameObject implements Serializable{
    
    public int x, y;
    public int homeX, homeY;
    public Tile home;
    public ID id;
    public Player owner;
    
    public GameObject(int x, int y, ID id, boolean TileCord, Player owner) {
    	if (TileCord) {
    		this.home = Game.handler.map.tiles[x][y];
    		this.homeX = x;
    		this.homeY = y;
            this.x = home.x;
            this.y = home.y;
            this.id = id;
    	} else {
    		this.x = x;
    		this.y = y;
    		this.id = id;
    	}
    }
    
    

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        if(x > Game.WIDTH - 32 || x < 0) {
            x = Game.WIDTH - 32;
        } else {
            this.x = x;
        }
    }
    
    public void setHome(int TileX, int TileY) {
    	
		this.home = Game.handler.map.tiles[TileX][TileY];
		this.homeX = TileX;
		this.homeY = TileY;
		MoveToHome();
    }
    
    public void setHome() {
    	this.home = Game.handler.map.tiles[homeX][homeY];
		MoveToHome();
    }
    
    public void MoveToHome () {
    	x = home.x;
    	y = home.y;
    }
    
    public int[] findHome(int x, int y) {
    	//This chords adjustment is because the tile x,y chords are on the top left corner. I want
    	//to click on the middle so I have to change the chords
    	x -= 30;
    	y -= 30;
    	Tile[][] mapTiles = Game.handler.map.tiles;
    	int newHomeX = 0, newHomeY = 0;
    	int sDistance = 100;
    	for (int i = 0; i < mapTiles.length; i++) {
    		for (int t = 0; t < mapTiles[i].length; t++) {
    			int distance = Math.abs(mapTiles[i][t].x - x) + Math.abs(mapTiles[i][t].y - y);
    			if (distance < sDistance) {
    				sDistance = distance;
    				newHomeX = i;
    				newHomeY = t;
    			}
    		}
    	}
    	return new int[] {newHomeX, newHomeY};
    }
    
    public void setY(int y){
        if(y > Game.HEIGHT || y < 0) {
        } else {
            this.y = y;
        }
    }
}