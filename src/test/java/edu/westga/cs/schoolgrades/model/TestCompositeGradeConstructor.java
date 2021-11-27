package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for CompositeGrade class constructor
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestCompositeGradeConstructor {

	/**
	 * test of null strategy
	 */
	@Test
	public void shouldNotAllowNullStrategy() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CompositeGrade(null);
		});
	}

	/**
	 * test empty composite grade
	 */
	@Test
	public void shouldHaveNoGradesWhenCreated() {
		CompositeGrade grade = new CompositeGrade(mock(GradeCalculationStrategy.class));
		assertTrue(grade.getGrades().isEmpty());
	}

}