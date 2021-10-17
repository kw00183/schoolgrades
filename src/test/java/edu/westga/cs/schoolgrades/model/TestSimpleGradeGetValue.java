package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for Simple Grade model class getValue method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestSimpleGradeGetValue {

	private SimpleGrade grade;

	@BeforeEach
	void setUp() throws Exception {
		this.grade = new SimpleGrade();
	}

	/**
	 * Test to check that creating SimpleGrade results in 0.0 grade value
	 */
	@Test
	public void createSimpleGradeShouldGetValue0() {
		assertEquals(0.0, this.grade.getValue());
	}

	/**
	 * Test to check that setting a valid grade returns set result
	 */
	@Test
	public void setValidGradeShouldGetValueSet() {
		this.grade.setValue(99.0);
		assertEquals(99.0, this.grade.getValue());
	}

	/**
	 * Test to check that setting an invalid negative grade returns 0.0 grade
	 * value
	 */
	@Test
	public void setInvalidNegativeGradeShouldTriggerError() {
		try {
			this.grade.setValue(-99.0);
		} catch (IllegalArgumentException iae) {
			assertEquals(
					"grade must be positive or less than or equal to 100.0",
					iae.getMessage());
		}
	}

	/**
	 * Test to check that setting an invalid high grade (grade over 100.0)
	 * returns 0.0 grade value
	 */
	@Test
	public void setInvalidHighGradeShouldTriggerError() {
		try {
			this.grade.setValue(105.0);
		} catch (IllegalArgumentException iae) {
			assertEquals(
					"grade must be positive or less than or equal to 100.0",
					iae.getMessage());
		}
	}
}