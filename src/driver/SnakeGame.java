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

public class SnakeGame implements GameEngine {
	private Snake snake;
	private final int SNAKE_LENGTH = 3;

	private Block block1;
	private Block block2;

	private final Color bgClr = Color.GRAY;
	private final Color snakeClr = Color.YELLOW;
	private final Color blockClr = Color.RED;

	private final int SCALE = 20;

	private Counter snakeTimer;

	public SnakeGame() throws InvalidDimensionException {
		snakeTimer = new Counter(5);

		snake = new Snake(SCALE, new Segment(null, null, Properties.WIDTH / 2, Properties.HEIGHT / 2));
		for (int i = 0; i < SNAKE_LENGTH; i++) {
			/* snake.update(); */
			snake.addSegment();
		}

		block1 = new Block(SCALE, Properties.WIDTH - SCALE - 1, Properties.HEIGHT / 2);
		block2 = new Block(SCALE, 1, Properties.HEIGHT / 2);
	}

	@Override
	public void run() throws InvalidDimensionException {
		if (snakeTimer.tick()) {
			snake.update();
			for (Block block : new Block[] { block1, block2 }) {
				if (snake.collidedWith(block)) {
					System.out.println("BINGO");
					snake.setDirection(snake.getDirection().multiply(-1));
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(bgClr);
		g.fillRect(0, 0, Properties.WIDTH, Properties.HEIGHT);
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
