package driver;

import java.awt.*;
import javax.swing.JFrame;

public class DisplayDriver extends Canvas {

	/**
	 * Main Driver
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private static final int WIDTH = 640, HEIGHT = 480;
	private static int x = 100;

	public void paint(Graphics g) {
		g.setColor(new Color(x, 55, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		/*
		 * setBackground(Color.WHITE); g.fillRect(130, 30, 100, 80); g.drawOval(30, 130,
		 * 50, 60); setForeground(Color.RED); g.fillOval(130, 130, 50, 60);
		 * g.drawArc(30, 200, 40, 50, 90, 60); g.fillArc(30, 130, 40, 50, 180, 40);
		 */

	}

	public void setUp() {
		frame = new JFrame();
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		DisplayDriver driver = new DisplayDriver();
		driver.setUp();
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x = (x + 1) % 255;
			driver.repaint();
			frame.revalidate();
		}
	}

}