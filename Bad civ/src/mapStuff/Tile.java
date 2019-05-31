package mapStuff;
import java.awt.Graphics;
import java.io.Serializable;

import mainBoi.GameObject;
import mainBoi.Handler;
import mainBoi.Building;
import mainBoi.Game;
import mainBoi.Window;
import mainBoi.ID;
import mainBoi.Soldier;
import java.util.LinkedList;
import java.util.List;

import Rendering.textures.Sprite;

public class Tile extends GameObject{
		
	public Tile(int x, int y, ID id) {
		
		super(x, y, id, false);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		id.image.render(g, x, y);
	}
}