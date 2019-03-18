package Rendering.textures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {
	
	private BufferedImage image;
	
	public Sprite(SpriteSheet sheet, int x, int y) {
		this.image = sheet.getTexture().getImage().getSubimage((x * sheet.getWidth()) - sheet.getWidth(),
				(y * sheet.getHeight()) - sheet.getHeight(), sheet.getWidth(), sheet.getHeight());
	}
	
	public void render(Graphics g, double x, double y) {
		g.drawImage(image, (int) x, (int) y, null);
	}
	
}
