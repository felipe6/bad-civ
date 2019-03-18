package mainBoi;
import Rendering.textures.Sprite;
import Rendering.textures.SpriteSheet;

public enum ID{
	
	LandTile (Ssheets.TILES, 1, 1),
	WaterTile (Ssheets.TILES, 2, 1),
	ForestTile (Ssheets.TILES, 1, 4),
	Player(),
    Enemy(),;
	
	public final Sprite image;
	
	ID(Ssheets sheet, int x, int y) {
		this.image = new Sprite (sheet.getSpriteSheet(), x, y);
	}
	
	ID(){
		image = null;
	}
	
    

}