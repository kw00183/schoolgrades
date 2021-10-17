package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for CompositeGrade model class setGradeStrategy method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestCompositeGradeSetGradeStrategy {

	private CompositeGrade composite;

	@BeforeEach
	void setUp() throws Exception {
		this.composite = new CompositeGrade();
	}

	/**
	 * Test to check that setGradeStrategy method sets "sum"
	 */
	@Test
	public void setGradeStrategyWithSum() {
		this.composite.setGradeStrategy("sum");
		assertEquals("sum", this.composite.getGradeStrategy());
	}

	/**
	 * Test to check that setGradeStrategy method sets "average"
	 */
	@Test
	public void setGradeStrategyWithAverage() {
		this.composite.setGradeStrategy("average");
		assertEquals("average", this.composite.getGradeStrategy());
	}

	/**
	 * Test to check that setGradeStrategy method sets "drop|average"
	 */
	@Test
	public void setGradeStrategyWithDropAverage() {
		this.composite.setGradeStrategy("drop|average");
		assertEquals("drop|average", this.composite.getGradeStrategy());
	}
}