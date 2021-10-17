package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for DropLowestGradeDecorator model class with
 * AverageGradeStrategy
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestDropLowestGradeDecoratorGetSubtotalAverageStrategy {

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test drop lowest grade logic with 1 grade and strategy is average
	 */
	@Test
	public void getSubtotalAverageGradeStrategyDropDecoratorWithOneGrade() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);

		GradeStrategy decoratedStrategy = new AverageGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(100.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic with 2 same grades and strategy is average
	 */
	@Test
	public void getSubtotalAverageGradeStrategyDropDecoratorWithTwoSameGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(100.0);

		GradeStrategy decoratedStrategy = new AverageGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(100.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic with 2 different grades and strategy is
	 * average
	 */
	@Test
	public void getSubtotalAverageGradeStrategyDropDecoratorWithTwoDifferentGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(70.0);

		GradeStrategy decoratedStrategy = new AverageGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(100.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic with 3 grades (2 same, 1 different) and
	 * strategy is average
	 */
	@Test
	public void getSubtotalAverageGradeStrategyDropDecoratorWithThreeGradesTwoSame() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(50.0);
		testArray.add(50.0);

		GradeStrategy decoratedStrategy = new AverageGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(75.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic when 3 grades are different and strategy is
	 * average
	 */
	@Test
	public void getSubtotalAverageGradeStrategyDropDecoratorWithThreeDifferentGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(75.0);
		testArray.add(50.0);

		GradeStrategy decoratedStrategy = new AverageGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(87.5, decorator.getSubtotal(testArray));
	}
}