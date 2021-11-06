package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Tests for SimpleGrade class constructor
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestSimpleGradeConstructor {

	private static final double DELTA = 0.001;

	/**
	 * test using negative grades
	 */
	@Test
	public void shouldNotAllowNegativeGrades() {
		assertThrows(IllegalArgumentException.class, () -> {
			new SimpleGrade(-1);
		});
	}

	/**
	 * test 0 grade values
	 */
	@Test
	public void shouldAllowZeroValue() {
		SimpleGrade grade = new SimpleGrade(0);
		assertEquals(0, grade.getValue(), DELTA);
	}

	/**
	 * test positive grade integer values
	 */
	@Test
	public void shouldAllowPositiveValue() {
		SimpleGrade grade = new SimpleGrade(50.0);
		assertEquals(50.0, grade.getValue(), DELTA);
	}

}