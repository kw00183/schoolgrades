package edu.westga.cs.schoolgrades.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;

/**
 * JUnit test class for CompositeGrade model class createArray method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestCompositeGradeSetArray {

	private CompositeGrade composite;

	@BeforeEach
	void setUp() throws Exception {
		this.composite = new CompositeGrade();
	}

	/**
	 * Test to check that setArray method with negative grade throws error
	 */
	@Test
	public void setArrayWithInvalidNegativeGradeThrowsError() {
		try {
			this.composite.setArray(-90.0);
		} catch (IllegalArgumentException iae) {
			assertEquals(
					"grade must be positive or less than or equal to 100.0",
					iae.getMessage());
		}
	}
	
	/**
	 * Test to check that setArray method with too high grade throws error
	 */
	@Test
	public void setArrayWithInvalidHighGradeThrowsError() {
		try {
			this.composite.setArray(105.0);
		} catch (IllegalArgumentException iae) {
			assertEquals(
					"grade must be positive or less than or equal to 100.0",
					iae.getMessage());
		}
	}
	
	/**
	 * Test to check that setArray method adds with valid grade
	 */
	@Test
	public void setArrayWithValidGrade() {
		this.composite.setArray(80.0);
		assertEquals("[80.0]", this.composite.getArray().toString());
	}
}