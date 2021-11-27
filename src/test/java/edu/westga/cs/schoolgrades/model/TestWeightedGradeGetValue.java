package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for WeightedGrade class getValue method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestWeightedGradeGetValue {

	private static final double DELTA = 0.001;
	private WeightedGrade weightedGrade;
	private Grade mockGrade;

	/**
	 * setup method run before each test
	 */
	@BeforeEach
	public void setup() {
		this.mockGrade = mock(Grade.class);
		when(mockGrade.getValue()).thenReturn(100.00);
	}

	/**
	 * test using 0 weight value
	 */
	@Test
	public void shouldApplyZeroWeight() {
		this.weightedGrade = new WeightedGrade(this.mockGrade, 0);
		assertEquals(0, this.weightedGrade.getValue(), DELTA);
	}

	/**
	 * test using 1 weight value
	 */
	@Test
	public void shouldApplyWeightOfOne() {
		this.weightedGrade = new WeightedGrade(this.mockGrade, 1);
		assertEquals(100, this.weightedGrade.getValue(), DELTA);
	}

	/**
	 * test using value between 0 and 1 weight value
	 */
	@Test
	public void shouldApplyWeightBetweenZeroAndOne() {
		this.weightedGrade = new WeightedGrade(this.mockGrade, 0.5);
		assertEquals(50, this.weightedGrade.getValue(), DELTA);
	}

}