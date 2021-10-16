package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Class for the strategy decorator to add additional logic the grades
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public abstract class GradeStrategyDecorator implements GradeStrategy {

	private GradeStrategy decoratedStrategy;

	/**
	 * Constructor for the GradeStrategyDecorator that accepts the strategy
	 * needed to apply the additional logic
	 * 
	 * @param decoratedStrategy
	 *            strategy needed to apply additional logic
	 */
	public GradeStrategyDecorator(GradeStrategy decoratedStrategy) {
		this.decoratedStrategy = decoratedStrategy;
	}

	@Override
	public double getSubtotal(ArrayList<Grade> grades) {
		return this.decoratedStrategy.getSubtotal(grades);
	}

	public GradeStrategy getDecoratedStrategy() {
		return this.decoratedStrategy;
	}

	public void setDecoratedStrategy(GradeStrategy decoratedStrategy) {
		this.decoratedStrategy = decoratedStrategy;
	}
}