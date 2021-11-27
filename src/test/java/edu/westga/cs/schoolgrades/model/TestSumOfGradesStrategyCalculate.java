package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for SumOfGradesStrategy class calculate method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestSumOfGradesStrategyCalculate {

	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	private List<Grade> grades;

	private SumOfGradesStrategy strategy;

	/**
	 * setup method run before each test
	 */
	@BeforeEach
	public void setup() {
		this.grade0 = mock(Grade.class);
		when(this.grade0.getValue()).thenReturn(10.00);
		this.grade1 = mock(Grade.class);
		when(this.grade1.getValue()).thenReturn(20.00);
		this.grade2 = mock(Grade.class);
		when(this.grade2.getValue()).thenReturn(30.00);

		this.grades = new ArrayList<Grade>();

		this.strategy = new SumOfGradesStrategy();
	}

	/**
	 * test sum with null grades list
	 */
	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.strategy.calculate(null);
		});
	}

	/**
	 * test sum with no grades
	 */
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, this.strategy.calculate(this.grades), DELTA);
	}

	/**
	 * test sum with one grade
	 */
	@Test
	public void shouldCalculateSumOfOneGrades() {
		this.grades.add(this.grade0);
		assertEquals(this.grade0.getValue(),
				this.strategy.calculate(this.grades), DELTA);
	}

	/**
	 * test sum with many grades
	 */
	@Test
	public void shouldCalculateSumOManyGrades() {
		this.grades.add(this.grade0);
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		assertEquals(60, this.strategy.calculate(this.grades), DELTA);
	}
}