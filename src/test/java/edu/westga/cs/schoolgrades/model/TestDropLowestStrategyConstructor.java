package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for DropLowestStrategy class constructor
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestDropLowestStrategyConstructor {

	/**
	 * setup method run before each test
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * test with null strategy
	 */
	@Test
	public void shouldNotAllowNullChildStrategy() {
		assertThrows(IllegalArgumentException.class, () -> {
			new DropLowestStrategy(null);
		});
	}
}