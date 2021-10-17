package edu.westga.cs.schoolgrades.model;

/**
 * Dummy class used to inherit TileGroup methods
 * @author Kim Weible
 * @version 2021.08.25
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