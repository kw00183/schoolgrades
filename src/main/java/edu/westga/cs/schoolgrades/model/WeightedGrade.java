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
	 */
	public WeightedGrade() {
		this.grade = 0.0;
	}

	/**
	 * Method used to set grade in need of weighting
	 * 
	 * @param grade
	 *            grade of double type
	 */
	public void setValue(double grade) {
		this.grade = grade;
	}

	/**
	 * Method implemented from Grade to return a double grade value
	 * 
	 * @return grade grade of double type
	 */
	@Override
	public double getValue() {
		return this.grade;
	}
}