package Rendering.textures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteSheet {

	private Texture texture;
	private int width, height;
	private Sprite[][] sprites;
	
	public SpriteSheet(Texture texture, int size) {
		this(texture, size, size);
	}
	
	public SpriteSheet(Texture texture, int width, int height) {
		this.texture = texture;
		this.width = width;
		this.height = height;
		this.sprites = new Sprite[width][height];
	}

	public Texture getTexture() {
		return texture;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Sprite extractSprite(int x, int y) {
		if (sprites[x][y] == null) {
			sprites[x][y] = new Sprite(this, x, y);
		}
		return sprites[x][y];
	}
}