package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for CompositeGrade class getValue method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestCompositeGradeGetValue {

	/**
	 * test composite grade returns accurate value with multiple grades and sum
	 * strategy
	 */
	@Test
	void shouldGetValue() {
		CompositeGrade composite = new CompositeGrade(
				new SumOfGradesStrategy());
		composite.add(new SimpleGrade(10));
		composite.add(new SimpleGrade(20));
		composite.add(new SimpleGrade(30));
		assertEquals(60, composite.getValue(), 0.01);
	}

}