package edu.westga.cs.schoolgrades.model;

public class GradeDecorator implements Grade {

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

	public Grade getDecoratedGrade() {
		return this.decoratedGrade;
	}

	public void setDecoratedGrade(Grade decoratedGrade) {
		this.decoratedGrade = decoratedGrade;
	}
}