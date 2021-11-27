package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for WeightedGrade class constructor
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestWeightedGradeConstructor {

	/**
	 * test weighting null grade
	 */
	@Test
	public void shouldNotAllowNullGrade() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(null, 10.0);
		});
	}

	/**
	 * test using negative weight value
	 */
	@Test
	public void shouldNotAllowNegativeWeight() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(mock(Grade.class), -10.0);
		});
	}

	/**
	 * test using weight greater than 1
	 */
	@Test
	public void shouldNotAllowWeightGreaterThanOne() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(mock(Grade.class), 10.0);
		});
	}
}