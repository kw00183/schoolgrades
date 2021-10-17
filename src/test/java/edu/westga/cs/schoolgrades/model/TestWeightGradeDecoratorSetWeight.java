package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for WeightGradeDecorator model class setWeight method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestWeightGradeDecoratorSetWeight {

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test weighting grade with 0.2 weight
	 */
	@Test
	public void getValueWeightGradeWeight2() {
		double gradeToWeight = 99.0;

		WeightedGrade decoratedGrade = new WeightedGrade();
		WeightGradeDecorator decorator = new WeightGradeDecorator(decoratedGrade);
		decoratedGrade.setValue(gradeToWeight);
		
		decorator.setDecoratedGrade(decoratedGrade);
		decorator.setWeight(0.2);

		assertEquals(19.8, decorator.getValue());
	}
	
	/**
	 * Test weighting grade with 0.3 weight
	 */
	@Test
	public void getValueWeightGradeWeight3() {
		double gradeToWeight = 99.0;

		WeightedGrade decoratedGrade = new WeightedGrade();
		WeightGradeDecorator decorator = new WeightGradeDecorator(decoratedGrade);
		decoratedGrade.setValue(gradeToWeight);
		
		decorator.setDecoratedGrade(decoratedGrade);
		decorator.setWeight(0.3);

		assertEquals(29.7, decorator.getValue());
	}
	
	/**
	 * Test weighting grade with 0.5 weight
	 */
	@Test
	public void getValueWeightGradeWeight5() {
		double gradeToWeight = 99.0;

		WeightedGrade decoratedGrade = new WeightedGrade();
		WeightGradeDecorator decorator = new WeightGradeDecorator(decoratedGrade);
		decoratedGrade.setValue(gradeToWeight);
		
		decorator.setDecoratedGrade(decoratedGrade);
		decorator.setWeight(0.5);

		assertEquals(49.5, decorator.getValue());
	}
}