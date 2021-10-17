package edu.westga.cs.schoolgrades.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SumGradeStrategy;

/**
 * JUnit test class for SumGradeStrategy model class getSubtotal method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestSumGradeStrategyGetSubtotal {

	private SumGradeStrategy strategy;

	@BeforeEach
	void setUp() throws Exception {
		this.strategy = new SumGradeStrategy();
	}

	/**
	 * Test to check that creating SumGradeStrategy with null parameter throws
	 * error
	 */
	@Test
	public void createSumGradeStrategyWithNullParameterThrowsError() {
		try {
			this.strategy.getSubtotal(null);
		} catch (NullPointerException npe) {
			assertEquals("grades cannot be null", npe.getMessage());
		}
	}

	/**
	 * Test to check that creating SumGradeStrategy with empty array returns 0.0
	 * sum
	 */
	@Test
	public void createSumGradeStrategyWithEmptyArraySum0() {
		ArrayList<Double> testArray = new ArrayList<Double>();

		assertEquals(0.0, this.strategy.getSubtotal(testArray));
	}

	/**
	 * Test to check that creating SumGradeStrategy with 1 value returns sum
	 * equal to value sum
	 */
	@Test
	public void createSumGradeStrategyWithOneGrade() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(10.0);

		assertEquals(10.0, this.strategy.getSubtotal(testArray));
	}

	/**
	 * Test to check that creating SumGradeStrategy with many values returns
	 * correct sum
	 */
	@Test
	public void createSumGradeStrategyWithManyGrades() {
		ArrayList<Double> testArray = new ArrayList<Double>();
		testArray.add(10.0);
		testArray.add(0.0);

		assertEquals(10.0, this.strategy.getSubtotal(testArray));
	}
}