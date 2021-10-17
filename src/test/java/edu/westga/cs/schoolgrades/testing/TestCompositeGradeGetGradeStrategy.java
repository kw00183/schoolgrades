package edu.westga.cs.schoolgrades.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;

/**
 * JUnit test class for CompositeGrade model class getGradeStrategy method
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public class TestCompositeGradeGetGradeStrategy {

	private CompositeGrade composite;

	@BeforeEach
	void setUp() throws Exception {
		this.composite = new CompositeGrade();
	}

	/**
	 * Test to check that getGradeStrategy method returns "sum"
	 */
	@Test
	public void getGradeStrategyWithSum() {
		this.composite.setGradeStrategy("sum");
		assertEquals("sum", this.composite.getGradeStrategy());
	}
}