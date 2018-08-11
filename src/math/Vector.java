package math;

import exceptions.InvalidDimensionException;

public class Vector {
	private int[] repr;

	public Vector(int... dimValues) {
		repr = dimValues.clone();
	}

	public Vector copy() {
		return new Vector(repr.clone());
	}

	public int getValueAt(final int dimension) throws InvalidDimensionException {
		if (dimension < 1 || dimension > size()) {
			throw new InvalidDimensionException();
		}
		return repr[dimension - 1];
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
		int[] sumArr = new int[size()];
		for (int i = 0; i < size(); i++) {
			sumArr[i] = this.repr[i] + other.repr[i];
		}
		return new Vector(sumArr);
	}

	public Vector subtract(Vector other) {
		return new Vector();
	}

	public Vector multiply(int scalar) {
		int[] productArr = new int[size()];
		for (int i = 0; i < size(); i++) {
			productArr[i] = repr[i] * scalar;
		}
		return new Vector(productArr);
	}

	public Vector reverse() {
		int[] reverseRepr = new int[size()];
		for (int i = 0; i < size(); i++) {
			reverseRepr[i] = repr[size() - 1 - i];
		}
		return new Vector(reverseRepr);
	}

	public int size() {
		return repr.length;
	}
}
