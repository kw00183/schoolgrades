package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for WeightedGrade model class setValue method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestWeightedGradeSetValue {

	private WeightedGrade weighted;

	@BeforeEach
	void setUp() throws Exception {
		this.weighted = new WeightedGrade();
	}

	/**
	 * Test to check that setValue method adds with valid grade
	 */
	@Test
	public void setArrayWithValidGrade() {
		this.weighted.setValue(80.0);
		assertEquals(80.0, this.weighted.getValue());
	}
}