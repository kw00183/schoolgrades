package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for WeightGradeDecorator model class getValue method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestWeightGradeDecoratorGetValue {

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test weighting grade with 0.2 weight
	 */
	@Test
	public void setWeightGradeWeight2() {
		double gradeToWeight = 99.0;

		WeightedGrade decoratedGrade = new WeightedGrade();
		WeightGradeDecorator decorator = new WeightGradeDecorator(decoratedGrade);
		decoratedGrade.setValue(gradeToWeight);
		
		decorator.setDecoratedGrade(decoratedGrade);
		decorator.setWeight(0.2);

		assertEquals(19.8, decorator.getValue());
	}
}