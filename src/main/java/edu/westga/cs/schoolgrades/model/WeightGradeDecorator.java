package edu.westga.cs.schoolgrades.model;

public class WeightGradeDecorator extends GradeDecorator {

	private Grade oldGrade;
	private double newGrade;
	private double gradeWeight;

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
	 */
	public double weightGrade(double gradeWeight) {
		this.oldGrade = super.getDecoratedGrade();
		this.newGrade = this.oldGrade.getValue() * gradeWeight;
		return newGrade;
	}
}