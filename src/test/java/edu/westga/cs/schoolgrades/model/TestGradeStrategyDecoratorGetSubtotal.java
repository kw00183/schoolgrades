package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for GradeStrategyDecorator model class getSubtotal method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestGradeStrategyDecoratorGetSubtotal {

	private DummyGradeStrategyDecorator dummyDecorator;

	@BeforeEach
	void setUp() throws Exception {
		this.dummyDecorator = new DummyGradeStrategyDecorator(
				this.dummyDecorator);
	}

	/**
	 * Test use dummy method to test abstract GradeStrategyDecorator getSubtotal
	 * method for sum strategy with 1 grade
	 */
	@Test
	public void getSubtotalGradeStrategyDecoratorWith1GradeSumStrategy() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);

		GradeStrategy decoratedStrategy = new SumGradeStrategy();
		this.dummyDecorator = new DummyGradeStrategyDecorator(
				decoratedStrategy);

		assertEquals(100.0, this.dummyDecorator.getSubtotal(testArray));
	}
	
	/**
	 * Test use dummy method to test abstract GradeStrategyDecorator getSubtotal
	 * method for sum strategy with 2 grades
	 */
	@Test
	public void getSubtotalGradeStrategyDecoratorWith2GradesSumStrategy() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(80.0);

		GradeStrategy decoratedStrategy = new SumGradeStrategy();
		this.dummyDecorator = new DummyGradeStrategyDecorator(
				decoratedStrategy);

		assertEquals(180.0, this.dummyDecorator.getSubtotal(testArray));
	}
}