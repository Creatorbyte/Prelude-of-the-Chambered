package com.mojang.escape.menu;

import com.mojang.escape.Art;
import com.mojang.escape.Game;
import com.mojang.escape.Sound;
import com.mojang.escape.gui.Bitmap;

public class InstructionsMenu extends Menu {
	private int tickDelay = 30;

	public void render(Bitmap target) {
		target.fill(0, 0, 640, 480, 0);

		target.draw("Instructions", 160, 32, Art.getCol(0xffffff));

		String[] lines = { "Use W,A,S,D to move, and",
				"the arrow keys to turn.", "", "The 1-8 keys select",
				"items from the inventory", "", "Space uses items", };

		for (int i = 0; i < lines.length; i++) {
			target.draw(lines[i], 16, 128 + i * 32, Art.getCol(0xa0a0a0));
		}

		if (tickDelay == 0)
			target.draw("-> Continue", 160, target.height - 64,
					Art.getCol(0xffff80));
	}

	public void tick(Game game, boolean up, boolean down, boolean left,
			boolean right, boolean use) {
		if (tickDelay > 0)
			tickDelay--;
		else if (use) {
			Sound.click1.play();
			game.setMenu(new TitleMenu());
		}
	}
}
