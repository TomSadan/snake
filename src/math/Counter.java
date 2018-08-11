package math;

public class Counter {
	private int value;
	private int max;

	public Counter(int max) {
		this.value = 0;
		this.max = max;
	}

	public boolean tick() {
		value++;
		if (value == max) {
			value = 0;
			return true;
		}
		return false;
	}

}
