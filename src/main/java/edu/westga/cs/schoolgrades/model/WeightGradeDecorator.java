package edu.westga.cs.schoolgrades.model;

/**
 * Class for the grade decorator to add additional logic the grades
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class WeightGradeDecorator extends GradeDecorator {

	private Grade oldGrade;
	private double newGrade;
	private double gradeWeight;

	/**
	 * Constructor for the GradeDecorator that accepts the grade to decorate and
	 * the weight to use
	 * 
	 * @param decoratedGrade
	 *            grade needed to apply additional logic
	 */
	public WeightGradeDecorator(Grade decoratedGrade) {
		super(decoratedGrade);
		this.gradeWeight = 1.0;
	}

	@Override
	public double getValue() {
		return this.weightGrade();
	}
	
	/**
	 * Method used to set weight to apply to grade
	 * 
	 * @param gradeWeight
	 *            weight to apply to grade
	 */
	public void setWeight(double gradeWeight) {
		this.gradeWeight = gradeWeight;
	}
	
	/**
	 * Method used to get weight to apply to grade
	 * 
	 * @return gradeWeight
	 *            weight to apply to grade
	 */
	public double getWeight() {
		return this.gradeWeight;
	}

	/**
	 * Method that accepts the weight needed and multiplies it to the grade
	 * (which could be a subtotal)
	 * 
	 * @return newGrade weighted grade
	 */
	public double weightGrade() {
		this.oldGrade = super.getDecoratedGrade();
		this.newGrade = this.oldGrade.getValue() * this.gradeWeight;
		return this.newGrade;
	}
}