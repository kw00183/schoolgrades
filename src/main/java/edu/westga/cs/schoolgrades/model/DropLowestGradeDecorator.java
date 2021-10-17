package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for the strategy decorator to drop lowest grade and apply strategy
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class DropLowestGradeDecorator extends GradeStrategyDecorator {

	/**
	 * Constructor accepts strategy to decorate with additional logic
	 * 
	 * @param decoratedStrategy
	 *            the strategy to decorate with additional logic
	 */
	public DropLowestGradeDecorator(GradeStrategy decoratedStrategy) {
		super(decoratedStrategy);
	}

	@Override
	public double getSubtotal(ArrayList<Double> grades) {
		ArrayList<Double> newGrades = this.dropLowestGrade(grades);
		return super.getDecoratedStrategy().getSubtotal(newGrades);
	}

	/**
	 * Method that drops the lowest grade from the list of grades
	 * 
	 * @param grades
	 *            grades to evaluate and drop lowest
	 * @return newGrades	new list of grades to apply strategy
	 */
	public ArrayList<Double> dropLowestGrade(ArrayList<Double> grades) {
		ArrayList<Double> newGrades = new ArrayList<Double>();
		
		if (grades == null || grades.size() == 0) {
			throw new NullPointerException("grades cannot be null or empty");
		} else if (grades.size() == 1) {
			newGrades = grades;
		} else {
			Collections.sort(grades, Collections.reverseOrder());
			
			for (int index = 0; index < grades.size() - 1; index++) {
				newGrades.add(grades.get(index));
			}	
		}
		return newGrades;
	}
}