package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Class for the strategy to average all the grades
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class AverageGradeStrategy implements GradeStrategy {

	@Override
	public double getSubtotal(ArrayList<Double> grades) {
		double averageGrades = 0.0;
		double sumGrades = 0.0;
		GradeStrategy strategy = new SumGradeStrategy();
		
		if (grades == null || grades.size() == 0) {
			throw new NullPointerException("grades cannot be null or empty");
		} else {
			sumGrades = strategy.getSubtotal(grades);
			averageGrades = sumGrades / grades.size();
		}
		return averageGrades;
	}	
}