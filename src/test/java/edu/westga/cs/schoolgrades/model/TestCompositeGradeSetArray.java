package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for CompositeGrade model class setArray method
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
	 * Test to check that setArray method adds with valid grade
	 */
	@Test
	public void setArrayWithValidGrade() {
		this.composite.setArray(80.0);
		assertEquals("[80.0]", this.composite.getArray().toString());
	}
}