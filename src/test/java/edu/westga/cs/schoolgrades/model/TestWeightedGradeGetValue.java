package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for WeightedGrade class getValue method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestWeightedGradeGetValue {

	private static final double DELTA = 0.001;
	private WeightedGrade weightedGrade;
	private SimpleGrade simpleGrade;

	/**
	 * setup method run before each test
	 */
	@BeforeEach
	public void setup() {
		this.simpleGrade = new SimpleGrade(100);
	}

	/**
	 * test using 0 weight value
	 */
	@Test
	public void shouldApplyZeroWeight() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 0);
		assertEquals(0, this.weightedGrade.getValue(), DELTA);
	}

	/**
	 * test using 1 weight value
	 */
	@Test
	public void shouldApplyWeightOfOne() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 1);
		assertEquals(100, this.weightedGrade.getValue(), DELTA);
	}

	/**
	 * test using value between 0 and 1 weight value
	 */
	@Test
	public void shouldApplyWeightBetweenZeroAndOne() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 0.5);
		assertEquals(50, this.weightedGrade.getValue(), DELTA);
	}

}