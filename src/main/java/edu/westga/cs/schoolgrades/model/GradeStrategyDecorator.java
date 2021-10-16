package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Class for the strategy decorator to add additional logic the grades
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public abstract class GradeStrategyDecorator implements GradeStrategy {

	private GradeStrategy strategy;

	/**
	 * Constructor for the GradeStrategyDecorator that accepts the strategy
	 * needed to apply the additional logic
	 * 
	 * @param strategy
	 *            strategy needed to apply additional logic
	 */
	public GradeStrategyDecorator(GradeStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Method that accepts the strategy needed and applies the additional logic
	 * 
	 * @param strategy
	 *            strategy needed to apply additional logic
	 */
	public void doAdditional(GradeStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public double getSubtotal(ArrayList<Grade> grades) {
		return this.strategy.getSubtotal(grades);
	}
}