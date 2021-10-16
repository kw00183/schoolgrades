package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

public class DropLowestGradeStrategy extends GradeStrategyDecorator {

	public DropLowestGradeStrategy(GradeStrategy decoratedStrategy) {
		super(decoratedStrategy);
	}

	@Override
	public double getSubtotal(ArrayList<Grade> grades) {
		ArrayList<Grade> newGrades = this.dropLowestGrade(grades);
		return super.getDecoratedStrategy().getSubtotal(newGrades);
	}
	
	/**
	 * Method that accepts the strategy needed and applies the additional logic
	 * 
	 * @param grades
	 *            strategy needed to apply additional logic
	 */
	public ArrayList<Grade> dropLowestGrade(ArrayList<Grade> grades) {
		return grades;
	}
}