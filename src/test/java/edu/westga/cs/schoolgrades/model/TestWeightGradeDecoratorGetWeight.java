package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for WeightGradeDecorator model class getWeight method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestWeightGradeDecoratorGetWeight {

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test weighting grade with 0.2 weight and get weight
	 */
	@Test
	public void getWeightGradeWeight2() {
		double gradeToWeight = 99.0;

		WeightedGrade decoratedGrade = new WeightedGrade();
		WeightGradeDecorator decorator = new WeightGradeDecorator(
				decoratedGrade);
		decoratedGrade.setValue(gradeToWeight);

		decorator.setDecoratedGrade(decoratedGrade);
		decorator.setWeight(0.2);

		assertEquals(0.2, decorator.getWeight());
	}
	
	/**
	 * Test weighting grade with 0.3 weight and get weight
	 */
	@Test
	public void getWeightGradeWeight3() {
		double gradeToWeight = 99.0;

		WeightedGrade decoratedGrade = new WeightedGrade();
		WeightGradeDecorator decorator = new WeightGradeDecorator(
				decoratedGrade);
		decoratedGrade.setValue(gradeToWeight);

		decorator.setDecoratedGrade(decoratedGrade);
		decorator.setWeight(0.3);

		assertEquals(0.3, decorator.getWeight());
	}
	
	/**
	 * Test weighting grade with 0.5 weight and get weight
	 */
	@Test
	public void getWeightGradeWeight5() {
		double gradeToWeight = 99.0;

		WeightedGrade decoratedGrade = new WeightedGrade();
		WeightGradeDecorator decorator = new WeightGradeDecorator(
				decoratedGrade);
		decoratedGrade.setValue(gradeToWeight);

		decorator.setDecoratedGrade(decoratedGrade);
		decorator.setWeight(0.5);

		assertEquals(0.5, decorator.getWeight());
	}
}