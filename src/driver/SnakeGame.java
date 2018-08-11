package driver;

import java.awt.Color;
import java.awt.Graphics;

import config.Properties;
import exceptions.InvalidDimensionException;
import game.Block;
import game.Segment;
import game.Snake;
import interfaces.GameEngine;
import math.Counter;
import math.Vector;

public class SnakeGame implements GameEngine {
	private Snake snake;
	private final int SNAKE_LENGTH = 5;

	private Block block1;
	private Block block2;

	private final Color bgClr = Color.GRAY;
	private final Color snakeClr = Color.YELLOW;
	private final Color blockClr = Color.RED;

	private Counter snakeTimer;

	public SnakeGame() throws InvalidDimensionException {
		snakeTimer = new Counter(5);

		snake = new Snake(Properties.SCALE, new Segment(null, null, Properties.WIDTH * Properties.SCALE / 2,
				Properties.HEIGHT * Properties.SCALE / 2), new Vector(Properties.SCALE, 0));
		for (int i = 0; i < SNAKE_LENGTH; i++) {
			snake.update();
			snake.addSegment();
		}

		block1 = new Block(Properties.SCALE, (Properties.WIDTH - 1) * Properties.SCALE,
				Properties.HEIGHT * Properties.SCALE / 2);
		block2 = new Block(Properties.SCALE, 0, Properties.HEIGHT * Properties.SCALE / 2);
	}

	@Override
	public void run() throws InvalidDimensionException {
		if (snakeTimer.tick()) {
			snake.update();
			for (Block block : new Block[] { block1, block2 }) {
				/*
				 * if (snake.collidedWith(block)) {
				 * snake.setDirection(snake.getDirection().reverse()); }
				 */
				if (snake.collidedWithHead(block)) {
					snake.setDirection(snake.getDirection().multiply(-1));
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		this.draw(g, bgClr);
		g.setColor(blockClr);
		for (Block block : new Block[] { block1, block2 }) {
			block.draw(g);
		}
		g.setColor(snakeClr);
		snake.draw(g);

	}

	public static void main(String[] args) throws Exception {
		DisplayDriver driver = new DisplayDriver(new SnakeGame(), "Snake Game Demo");
		driver.run(100);
	}
}
