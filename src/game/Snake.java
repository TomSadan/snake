package game;

import java.awt.Graphics;

import config.Properties;
import exceptions.InvalidDimensionException;
import math.Vector;

public class Snake {
	private Segment head;
	private Segment tail;
	private Vector direction;
	private int scale;

	public Snake(int scale, Segment head) {
		this.head = head;
		this.tail = head;
		this.scale = scale;
		this.direction = new Vector(scale, 0);
	}

	public void update() throws InvalidDimensionException {
		int newX = head.x + direction.getValueAt(Properties.X_DIM);
		int newY = head.y + direction.getValueAt(Properties.Y_DIM);
		head.refreshSegmentCluster(newX, newY);
	}

	public void draw(Graphics g) {
		Segment curr = head;
		while (curr != null) {
			g.drawRect(curr.x, curr.y, scale, scale);
			curr = curr.tail;
		}
	}

	public boolean collidedWith(Block block) {
		Segment curr = head;
		while (curr != null) {
			if (curr.x == block.x && curr.y == block.y)
				return true;
			curr = curr.tail;
		}
		return false;
	}

	public void addSegment() {
		this.tail.tail = new Segment(this.tail, null, this.tail.x, this.tail.y);
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) throws InvalidDimensionException {
		if (direction.size() > 2)
			throw new InvalidDimensionException();

		this.direction = direction.copy();

	}
}
