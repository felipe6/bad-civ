package playerInfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Rendering.textures.TextBox;

public class UIHandler {
	
	private Player player;
	private TopStatsBarUI stats;
	
	public UIHandler (Player player) {
		
		this.player = player;
		stats = new TopStatsBarUI(player);
		
	}
	
	public void tick() {
		stats.updateStats();
	}
	
	public void render(Graphics g) {
		stats.Render(g);
	}	
}