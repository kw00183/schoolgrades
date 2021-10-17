package edu.westga.cs.schoolgrades.model;

/**
 * Dummy class used to inherit GradeStrategyDecorator methods
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class DummyGradeStrategyDecorator extends GradeStrategyDecorator {

	/** creates a dummy class object
	 * 
	 * @param decoratedStrategy	strategy to use to decorate
	 */
	public DummyGradeStrategyDecorator(GradeStrategy decoratedStrategy) {
		super(decoratedStrategy);
	}
}