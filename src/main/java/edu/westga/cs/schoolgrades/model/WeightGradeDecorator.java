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
	 * @param gradeWeight
	 *            weight needed to apply to grade
	 */
	public WeightGradeDecorator(Grade decoratedGrade, double gradeWeight) {
		super(decoratedGrade);
		this.gradeWeight = gradeWeight;
	}

	@Override
	public double getValue() {
		return this.weightGrade(this.gradeWeight);
	}

	/**
	 * Method that accepts the weight needed and multiplies it to the grade
	 * (which could be a subtotal)
	 * 
	 * @param gradeWeight
	 *            weight needed to multply with the grade
	 * @return newGrade weighted grade
	 */
	public double weightGrade(double gradeWeight) {
		this.oldGrade = super.getDecoratedGrade();
		this.newGrade = this.oldGrade.getValue() * gradeWeight;
		return this.newGrade;
	}
}