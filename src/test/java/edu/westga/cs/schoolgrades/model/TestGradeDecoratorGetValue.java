package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for GradeDecorator model class getValue method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestGradeDecoratorGetValue {

	private DummyGradeDecorator dummyDecorator;

	@BeforeEach
	void setUp() throws Exception {
		this.dummyDecorator = new DummyGradeDecorator(
				this.dummyDecorator);
	}

	/**
	 * Test use dummy method to test abstract GradeDecorator getValue
	 * method
	 */
	@Test
	public void getValueGradeDecoratorWith1Grade() {
		double gradeToWeight = 99.0;
		
		WeightedGrade decoratedGrade = new WeightedGrade();
		this.dummyDecorator = new DummyGradeDecorator(
				decoratedGrade);
		
		decoratedGrade.setValue(gradeToWeight);
		this.dummyDecorator.setDecoratedGrade(decoratedGrade);

		assertEquals(99.0, this.dummyDecorator.getValue());
	}
}