package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for CompositeGrade model class getValue method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestCompositeGradeGetValue {

	private CompositeGrade composite;

	@BeforeEach
	void setUp() throws Exception {
		this.composite = new CompositeGrade();
	}

	/**
	 * Test to check that getValue method returns correct value for sum
	 */
	@Test
	public void getValueCompositeGradeSum() {
		this.composite.setArray(10.0);
		this.composite.setArray(20.0);
		this.composite.setArray(20.0);

		this.composite.setGradeStrategy("sum");
		assertEquals(50.0, this.composite.getValue());
	}

	/**
	 * Test to check that getValue method returns correct value for average
	 */
	@Test
	public void getValueCompositeGradeAverage() {
		this.composite.setArray(100.0);
		this.composite.setArray(80.0);
		this.composite.setArray(75.0);

		this.composite.setGradeStrategy("average");
		assertEquals(85.0, this.composite.getValue());
	}

	/**
	 * Test to check that getValue method returns correct value for drop|average
	 */
	@Test
	public void getValueCompositeGradeDropLowestAverage() {
		this.composite.setArray(100.0);
		this.composite.setArray(80.0);
		this.composite.setArray(75.0);

		this.composite.setGradeStrategy("drop|average");
		assertEquals(90.0, this.composite.getValue());
	}
}