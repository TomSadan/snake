package driver;

import java.awt.*;
import javax.swing.JFrame;

import config.Properties;
import interfaces.GameEngine;

public class DisplayDriver extends Canvas {

	/**
	 * Main Driver
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private GameEngine engine;

	private boolean run = false;

	public DisplayDriver(GameEngine engine) {
		this.engine = engine;
		setup();
	}

	public void paint(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Properties.WIDTH, Properties.HEIGHT);
		engine.run();
		engine.draw(g);
	}

	private void setup() {
		frame = new JFrame();
		frame.add(this);
		frame.setSize(Properties.WIDTH, Properties.HEIGHT);
		frame.setVisible(true);
		run = true;
	}

	public void run() {
		run(-1);
	}

	public void run(int delay) {
		while (run) {
			if (delay != -1) {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			repaint();
			frame.revalidate();
		}
	}

}