package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for CompositeGrade model class getArray method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestCompositeGradeGetArray {

	private CompositeGrade composite;

	@BeforeEach
	void setUp() throws Exception {
		this.composite = new CompositeGrade();
	}

	/**
	 * Test to check that setArray method adds with 1 valid grade
	 */
	@Test
	public void setArrayWith1ValidGrade() {
		this.composite.setArray(80.0);
		assertEquals("[80.0]", this.composite.getArray().toString());
	}
	
	/**
	 * Test to check that setArray method adds with 2 valid grades
	 */
	@Test
	public void setArrayWith2ValidGrades() {
		this.composite.setArray(80.0);
		this.composite.setArray(0.0);
		assertEquals("[80.0, 0.0]", this.composite.getArray().toString());
	}
	
	/**
	 * Test to check that setArray method adds with 3 valid grades
	 */
	@Test
	public void setArrayWith3ValidGrades() {
		this.composite.setArray(80.0);
		this.composite.setArray(50.0);
		this.composite.setArray(0.0);
		assertEquals("[80.0, 50.0, 0.0]", this.composite.getArray().toString());
	}
}