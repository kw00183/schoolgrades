package edu.westga.cs.schoolgrades.model;

/**
 * A {@link Grade} with a constant value.
 * 
 * @author lewisb
 * @version cs6241
 */
public class SimpleGrade implements Grade {
	private double value;

	/**
	 * Creates a SimpleGrade with the given value.
	 * 
	 * @param value
	 *            the assigned numerical grade. Must be >= 0
	 */
	public SimpleGrade(double value) {
		this.setValue(value);
	}

	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the simple grade value
	 */
	public void setValue(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("value should not be < 0");
		}

		this.value = value;
	}

}