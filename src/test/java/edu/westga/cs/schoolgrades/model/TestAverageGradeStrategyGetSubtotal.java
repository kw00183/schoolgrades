package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for SumGradeStrategy model class getSubtotal method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestAverageGradeStrategyGetSubtotal {

	private AverageGradeStrategy strategy;

	@BeforeEach
	void setUp() throws Exception {
		this.strategy = new AverageGradeStrategy();
	}

	/**
	 * Test to check that creating AverageGradeStrategy with null parameter
	 * throws error
	 */
	@Test
	public void getSubtotalAverageGradeStrategyWithNullParameterThrowsError() {
		try {
			this.strategy.getSubtotal(null);
		} catch (NullPointerException npe) {
			assertEquals("grades cannot be null or empty", npe.getMessage());
		}
	}

	/**
	 * Test to check that creating AverageGradeStrategy with empty array throws
	 * error
	 */
	@Test
	public void getSubtotalAverageGradeStrategyWithEmptyArrayThrowsError() {
		ArrayList<Double> testArray = new ArrayList<Double>();

		try {
			this.strategy.getSubtotal(testArray);
		} catch (NullPointerException npe) {
			assertEquals("grades cannot be null or empty", npe.getMessage());
		}
	}
	
	/**
	 * Test to check that creating AverageGradeStrategy with 1 grade returns average equal to grade
	 */
	@Test
	public void getSubtotalAverageGradeStrategyWithOneGrade() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(10.0);

		assertEquals(10.0, this.strategy.getSubtotal(testArray));
	}
	
	/**
	 * Test to check that creating AverageGradeStrategy with 2 grades returns correct average
	 */
	@Test
	public void getSubtotalAverageGradeStrategyWithTwoGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(70.0);

		assertEquals(85.0, this.strategy.getSubtotal(testArray));
	}
	
	/**
	 * Test to check that creating AverageGradeStrategy with 3 grades (1 is 0.0) returns correct average
	 */
	@Test
	public void getSubtotalAverageGradeStrategyWithThreeGradesOne0() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(100.0);
		testArray.add(70.0);
		testArray.add(0.0);

		Double roundAverageGrade = Math.round(this.strategy.getSubtotal(testArray) * 100.0) / 100.0;
		assertEquals(56.67, roundAverageGrade);
	}
}