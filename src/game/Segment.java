package game;

public class Segment {
	public Segment head;
	public Segment tail;
	public int x;
	public int y;

	public Segment(Segment head, Segment tail, int x, int y) {
		this.head = head;
		this.tail = tail;
		this.x = x;
		this.y = y;
	}

	public void refreshSegmentCluster(int x, int y) {
		if (tail != null) {
			tail.refreshSegmentCluster(this.x, this.y);
		}
		this.x = x;
		this.y = y;

	}
}
