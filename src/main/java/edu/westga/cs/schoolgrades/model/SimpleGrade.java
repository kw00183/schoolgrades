package edu.westga.cs.schoolgrades.model;

/**
 * Class for the simple grade that implements Grade
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class SimpleGrade implements Grade {

	private double grade;

	/**
	 * Creates a new simple grade that retrieves the grade value
	 * 
	 * @param grade
	 *            double value of grade
	 */
	public SimpleGrade(double grade) {
		this.grade = grade;
	}

	/**
	 * Method implemented from Grade to return a double grade value
	 * 
	 * @return grade
	 *            double value of grade
	 */
	@Override
	public double getValue() {
		return this.grade;
	}
}