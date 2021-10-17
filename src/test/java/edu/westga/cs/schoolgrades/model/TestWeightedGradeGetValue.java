package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for WeightedGrade model class getValue method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestWeightedGradeGetValue {

	private WeightedGrade weighted;

	@BeforeEach
	void setUp() throws Exception {
		this.weighted = new WeightedGrade();
	}

	/**
	 * Test to check that getValue method returns valid grade
	 */
	@Test
	public void getArrayWithValidGrade() {
		this.weighted.setValue(80.0);
		assertEquals(80.0, this.weighted.getValue());
	}
}