package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Class for the composite grade that implements Grade
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class CompositeGrade implements Grade {

	private ArrayList<Double> grades;
	private String strategy;

	/**
	 * Creates a new composite grade object and instantiates the ArrayList
	 */
	public CompositeGrade() {
		this.grades = new ArrayList<Double>();
	}

	/**
	 * Method used to set the grades values required for composite grade
	 * 
	 * @param grade
	 *            double value of grade
	 */
	public void setArray(double grade) {
		if (grade < 0.0 || grade > 100.0) {
			throw new IllegalArgumentException(
					"grade must be positive or less than or equal to 100.0");
		}
		this.grades.add(grade);
	}

	/**
	 * Method used to get the grades values required for composite grade
	 * 
	 * @return grades array list of double grade values
	 */
	public ArrayList<Double> getArray() {
		return this.grades;
	}

	/**
	 * Method used to set the strategy to create the composite grade
	 * 
	 * @param strategy
	 *            the string value of the strategy to use to create the
	 *            composite grade
	 */
	public void setGradeStrategy(String strategy) {
		if (strategy == null) {
			throw new NullPointerException("strategy cannot be null");
		} else if (strategy.isEmpty()) {
			throw new IllegalArgumentException("strategy cannot be empty");
		}
		this.strategy = strategy;
	}

	/**
	 * Method used to get the strategy value required for composite grade
	 * 
	 * @return strategy string of strategy to use
	 */
	public String getGradeStrategy() {
		return this.strategy;
	}

	/**
	 * Method implemented from Grade to return a double grade value using the
	 * set strategy
	 * 
	 * @return grade double value representing composite grade
	 */
	@Override
	public double getValue() {
		GradeStrategy implementStrategy;

		if (this.strategy.equals("sum")) {
			implementStrategy = new SumGradeStrategy();
		} else if (this.strategy.equals("average")) {
			implementStrategy = new AverageGradeStrategy();
		} else if (this.strategy.equals("drop|average")) {
			implementStrategy = new AverageGradeStrategy();
			implementStrategy = new DropLowestGradeDecorator(implementStrategy);
		} else {
			throw new IllegalArgumentException("invalid strategy");
		}
		return implementStrategy.getSubtotal(this.grades);
	}
}