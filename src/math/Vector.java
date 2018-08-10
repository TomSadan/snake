package math;

public class Vector {
	private int[] repr;

	public Vector(int... dimValues) {
		repr = dimValues.clone();
	}

	public boolean equals(Vector other) {
		return this.toString() == other.toString();
	}

	public String toString() {
		String s = "[";
		for (int dim : repr) {
			s += Integer.toString(dim) + " ";
		}
		s = s.trim() + "]";

		return s;
	}

	public Vector add(Vector other) {
		int[] sumArr = new int[repr.length];
		for (int i = 0; i < repr.length; i++) {
			sumArr[i] = this.repr[i] + other.repr[i];
		}
		return new Vector(sumArr);
	}

	public Vector subtract(Vector other) {
		return new Vector();
	}

	public Vector multiply(int scalar) {
		int[] productArr = new int[repr.length];
		for (int i = 0; i < repr.length; i++) {
			productArr[i] = repr[i] * scalar;
		}
		return new Vector(productArr);
	}
	
	private Vector operation()
}
