package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Class for the strategy to sum all the grades
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class SumGradeStrategy implements GradeStrategy {

	@Override
	public double getSubtotal(ArrayList<Double> grades) {
		double sumGrades = 0.0;
		if (grades == null) {
			throw new NullPointerException("grades cannot be null");
		} else {
			for (int index = 0; index < grades.size(); index++) {
				sumGrades += grades.get(index);
			}
		}
		return sumGrades;
	}
}