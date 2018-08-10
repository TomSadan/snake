package driver;

import java.awt.Graphics;

import config.Properties;
import game.Segment;
import interfaces.GameEngine;

public class SnakeGame implements GameEngine {
	private Segment snakeHead;

	public SnakeGame() {
		snakeHead = new Segment(null, null, Properties.WIDTH / 2, Properties.HEIGHT / 2);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		SnakeGame game = new SnakeGame();
		DisplayDriver driver = new DisplayDriver(new SnakeGame());
		driver.run();
	}
}
