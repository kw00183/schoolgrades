package edu.westga.cs.schoolgrades.model;

/**
 * Class for the grade decorator to add additional logic to weight grades
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public abstract class GradeDecorator implements Grade {

	private Grade decoratedGrade;

	/**
	 * Constructor for the GradeDecorator that accepts the grade
	 * needed to apply the additional logic
	 * 
	 * @param decoratedGrade
	 *            grade needed to apply additional logic
	 */
	public GradeDecorator(Grade decoratedGrade) {
		this.decoratedGrade = decoratedGrade;
	}

	@Override
	public double getValue() {
		return this.decoratedGrade.getValue();
	}

	/**
	 * Method used to get decorated grade in need of weighting
	 * 
	 * @return grade
	 *            grade has been decorated
	 */
	public Grade getDecoratedGrade() {
		return this.decoratedGrade;
	}

	/**
	 * Method used to set decorated grade in need of weighting
	 * 
	 * @param decoratedGrade
	 *            grade has been decorated
	 */
	public void setDecoratedGrade(Grade decoratedGrade) {
		this.decoratedGrade = decoratedGrade;
	}
}