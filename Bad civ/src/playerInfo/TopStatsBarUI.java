package playerInfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Rendering.textures.ChangingTextBox;
import Rendering.textures.TextBox;

public class TopStatsBarUI {
	
	private ChangingTextBox[] PlayerInfo;
	Player player;
	
	public TopStatsBarUI(Player player) {
		PlayerInfo = new ChangingTextBox[4];
		this.player = player;
		FillPlayerInfo();
	}
	
	public void Render(Graphics g) {
		for (int i = 0; i < PlayerInfo.length; i++) {
			if (PlayerInfo[i] != null) {
				PlayerInfo[i].render(g);
			}
		}
	}
	
	public void updateStats() {
		PlayerInfo[0].updateStat(player.population);
	}

	public void FillPlayerInfo() {
		PlayerInfo[0] = new ChangingTextBox ("Population: ", 10, 10, new Font("Ariel", Font.PLAIN, 11), Color.BLACK);
	}
}
