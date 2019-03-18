package mainBoi;

import Rendering.textures.SpriteSheet;
import Rendering.textures.Texture;

public enum Ssheets {

	TILES("tilesheetTrans", 64);
	
	private final SpriteSheet sheet;
	
	Ssheets(String file, int size){
    	sheet = new SpriteSheet(new Texture(file), size);
	}
	
	public SpriteSheet getSpriteSheet() {
		return this.sheet;
	}
}
