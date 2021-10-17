package edu.westga.cs.schoolgrades.model;

/**
 * Dummy class used to inherit GradeDecorator methods
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class DummyGradeDecorator extends GradeDecorator {

	/** creates a dummy class object
	 * 
	 * @param decoratedGrade	grade to use to decorate
	 */
	public DummyGradeDecorator(Grade decoratedGrade) {
		super(decoratedGrade);
	}
}