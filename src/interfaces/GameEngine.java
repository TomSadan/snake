package interfaces;

import java.awt.Color;
import java.awt.Graphics;

import config.Properties;

public interface GameEngine {

	public void run() throws Exception;

	public default void draw(Graphics g) {
		draw(g, Color.BLACK);
	}

	public default void draw(Graphics g, Color clr) {
		g.setColor(clr);
		g.fillRect(0, 0, Properties.WIDTH * Properties.SCALE, Properties.HEIGHT * Properties.SCALE);

	}
}
