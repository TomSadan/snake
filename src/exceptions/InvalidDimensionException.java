package exceptions;

public class InvalidDimensionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDimensionException() {
		super();
		System.err.println(
				"Dimension value must be greater than 0 and no greater than the highest dimension of the vector.");
	}

}
