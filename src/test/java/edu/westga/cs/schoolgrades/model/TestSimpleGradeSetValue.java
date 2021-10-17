package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for Simple Grade model class setValue method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestSimpleGradeSetValue {

	private SimpleGrade grade;

	@BeforeEach
	void setUp() throws Exception {
		this.grade = new SimpleGrade();
	}

	/**
	 * Test to check that setting a valid grade returns set result
	 */
	@Test
	public void setValueWithValidGrade() {
		this.grade.setValue(99.0);
		assertEquals(99.0, this.grade.getValue());
	}

	/**
	 * Test to check that setting negative grades throws error
	 */
	@Test
	public void setValueWithNegativeGradeThrowError() {
		try {
			this.grade.setValue(-99.0);
		} catch (IllegalArgumentException iae) {
			assertEquals(
					"grade must be positive or less than or equal to 100.0",
					iae.getMessage());
		}
	}
	
	/**
	 * Test to check that setting high grades throws error
	 */
	@Test
	public void setValueWithHighGradeThrowError() {
		try {
			this.grade.setValue(105.0);
		} catch (IllegalArgumentException iae) {
			assertEquals(
					"grade must be positive or less than or equal to 100.0",
					iae.getMessage());
		}
	}
}