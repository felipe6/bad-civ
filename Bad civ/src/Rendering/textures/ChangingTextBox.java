package Rendering.textures;

import java.awt.Color;
import java.awt.Font;

public class ChangingTextBox extends TextBox{

	private String baseText;
	
	public ChangingTextBox(String text, int textY, int textX, Font font, Color color) {
		super(text, textY, textX, font, color);
	}
	
	public void updateStat(int newStat) {
		text = baseText + newStat;
	}
}
