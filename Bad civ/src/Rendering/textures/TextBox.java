package Rendering.textures;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import mainBoi.Game;
import utilities.managers.Fonts;

public class TextBox extends Rectangle{
	
	private Font font;
	private Color color;
	public String text;
	private int textY;
	private int textX;
	
	public TextBox(String text, int textY, int textX, Font font, Color color) {
		super();
		this.text = text;
		this.textY = textY;
		this.textX = textX;
		this.font = font;
		this.color = color;
	}
	
	public void render(Graphics g) {

		Fonts.drawString(g, font, color, text, textY, textX);
		FontMetrics fm = g.getFontMetrics();
		this.x = (Game.WIDTH - fm.stringWidth(text)) / 2;
		this.y = textY - fm.getHeight();
		this.width = fm.stringWidth(text);
		this.height = fm.getHeight();
		//g.drawRect(x, y, width, height);
		
	}
}