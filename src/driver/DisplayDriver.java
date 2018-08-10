package driver;

import java.awt.*;
import javax.swing.JFrame;

import config.Properties;
import interfaces.GameEngine;

public class DisplayDriver extends JFrame {

	/**
	 * Main Driver
	 */
	private static final long serialVersionUID = 1L;
	private GameEngine engine;

	private boolean run = false;

	public DisplayDriver(GameEngine engine) {
		this.engine = engine;
		setup();
	}

	public void paint(Graphics g) {
		engine.draw(g);
	}

	private void setup() {
		setSize(Properties.WIDTH, Properties.HEIGHT);
		setVisible(true);
		run = true;
	}

	public void run() throws Exception {
		run(-1);
	}

	public void run(int delay) throws Exception {
		while (run) {
			if (delay != -1) {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			engine.run();
			repaint();
			revalidate();
		}
	}

}