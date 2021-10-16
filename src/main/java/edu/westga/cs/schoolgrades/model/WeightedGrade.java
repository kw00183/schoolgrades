package edu.westga.cs.schoolgrades.model;

/**
 * Class for the weighted grade that implements Grade
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class WeightedGrade implements Grade {

	private double grade;
	
	/**
	 * Creates a new composite grade object
	 * 
	 * @param grade
	 *            double value of grade
	 */
	public WeightedGrade(double grade) {
		this.grade = grade;
	}

	/**
	 * Method implemented from Grade to return a double grade value
	 * 
	 * @return grade
	 *            double value of grade
	 */
	public double getValue() {
		return this.grade;
	}
}