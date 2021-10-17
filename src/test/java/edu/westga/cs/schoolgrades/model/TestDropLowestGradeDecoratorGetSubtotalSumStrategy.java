package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.DropLowestGradeDecorator;
import edu.westga.cs.schoolgrades.model.GradeStrategy;
import edu.westga.cs.schoolgrades.model.SumGradeStrategy;

/**
 * JUnit test class for DropLowestGradeDecorator model class with
 * SumGradeStrategy
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestDropLowestGradeDecoratorGetSubtotalSumStrategy {

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test drop lowest grade logic with 1 grade and strategy is sum
	 */
	@Test
	public void getSubtotalSumGradeStrategyDropDecoratorWithOneGrade() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);

		GradeStrategy decoratedStrategy = new SumGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(100.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic with 2 same grades and strategy is sum
	 */
	@Test
	public void getSubtotalSumGradeStrategyDropDecoratorWithTwoSameGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(100.0);

		GradeStrategy decoratedStrategy = new SumGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(100.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic with 2 different grades and strategy is sum
	 */
	@Test
	public void getSubtotalSumGradeStrategyDropDecoratorWithTwoDifferentGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(70.0);

		GradeStrategy decoratedStrategy = new SumGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(100.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic with 3 grades (2 same, 1 different) and
	 * strategy issum
	 */
	@Test
	public void getSubtotalSumGradeStrategyDropDecoratorWithThreeGradesTwoSame() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(50.0);
		testArray.add(50.0);

		GradeStrategy decoratedStrategy = new SumGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(150.0, decorator.getSubtotal(testArray));
	}

	/**
	 * Test drop lowest grade logic when 3 grades are different and strategy is
	 * sum
	 */
	@Test
	public void getSubtotalSumGradeStrategyDropDecoratorWithThreeDifferentGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(75.0);
		testArray.add(50.0);

		GradeStrategy decoratedStrategy = new SumGradeStrategy();
		DropLowestGradeDecorator decorator = new DropLowestGradeDecorator(
				decoratedStrategy);

		assertEquals(175.0, decorator.getSubtotal(testArray));
	}
}