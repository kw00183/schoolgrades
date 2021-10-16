package edu.westga.cs.schoolgrades.model;

/**
 * Class for the composite grade that implements Grade
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class CompositeGrade implements Grade {

	private double grade;
	
	/**
	 * Creates a new composite grade object
	 * 
	 * @param grade
	 *            double value of grade
	 */
	public CompositeGrade(double grade) {
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