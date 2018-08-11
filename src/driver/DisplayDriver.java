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

	public DisplayDriver(GameEngine engine) {
		this.engine = engine;
		setSize(Properties.WIDTH, Properties.HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
	}

	public DisplayDriver(GameEngine engine, String title) {
		this(engine);
		this.setTitle(title);
	}

	public void paint(Graphics g) {
		engine.draw(g);
	}

	public void run() throws Exception {
		run(-1);
	}

	public void run(int delay) throws Exception {
		while (isVisible()) {
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