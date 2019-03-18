package Rendering.textures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import utilities.managers.TextureManager;;


public class Texture{
    
	private final static Map<String, TextureManager> texMap = new HashMap<String, TextureManager>();
	private TextureManager manager;
	private String fileName;
	
	public Texture(String fileName) {
		this.fileName = fileName;
		TextureManager oldTexture = texMap.get(fileName);
		if(oldTexture != null) {
			manager = oldTexture;
			manager.addReference();
		}else {
			try {
				manager = new TextureManager(ImageIO.read(new File("./resources/textures/" + fileName + ".png")));
				texMap.put(fileName, manager);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		if(manager.removeReference() && !fileName.isEmpty())
			texMap.remove(fileName);
		super.finalize();
	}
	
	public void render(Graphics g, double x, double y) {
		g.drawImage(manager.getImage(), (int) x, (int) y, null);
	}
	
	public BufferedImage getImage() {
		return manager.getImage();
	}
}