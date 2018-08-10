package game;

import java.awt.Graphics;

public class Block {
	public int x;
	public int y;
	public int scale;

	public Block(int scale, int x, int y) {
		this.scale = scale;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.fillRect(x, y, scale, scale);
	}
}
