package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for DropLowestStrategy class calculate method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestDropLowestStrategyCalculate {
	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockStrategy;

	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	private List<Grade> grades;

	/**
	 * setup method run before each test
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.grade0 = mock(Grade.class);
		when(this.grade0.getValue()).thenReturn(10.00);
		this.grade1 = mock(Grade.class);
		when(this.grade1.getValue()).thenReturn(20.00);
		this.grade2 = mock(Grade.class);
		when(this.grade2.getValue()).thenReturn(30.00);

		this.grades = new ArrayList<Grade>();
		
		this.mockStrategy = mock(GradeCalculationStrategy.class);
		this.dropLowestStrategy = new DropLowestStrategy(mockStrategy);
	}

	/**
	 * test using null grade list
	 */
	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.dropLowestStrategy.calculate(null);
		});
	}

	/**
	 * test using empty grade list
	 */
	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		ArrayList<Grade> gradesNew = new ArrayList<Grade>();		
		
		this.dropLowestStrategy.calculate(this.grades);
		
		verify(this.mockStrategy, times(1)).calculate(gradesNew);
	}

	/**
	 * test trying to drop lowest grade with one grade
	 */
	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		this.grades.add(this.grade0);

		ArrayList<Grade> gradesNew = new ArrayList<Grade>();
		gradesNew.add(this.grade0);
		
		this.dropLowestStrategy.calculate(this.grades);
		
		verify(this.mockStrategy, times(1)).calculate(gradesNew);
	}

	/**
	 * test trying to drop lowest grade with many grades
	 */
	@Test
	public void canDropWhenLowestIsFirst() {
		this.grades.add(this.grade0);
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		
		ArrayList<Grade> gradesNew = new ArrayList<Grade>();
		gradesNew.add(this.grade1);
		gradesNew.add(this.grade2);
		
		this.dropLowestStrategy.calculate(this.grades);
		
		verify(this.mockStrategy, times(1)).calculate(gradesNew);
	}

	/**
	 * test trying to drop lowest grade with many grades and lowest is last
	 */
	@Test
	public void canDropWhenLowestIsLast() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		this.grades.add(this.grade0);

		ArrayList<Grade> gradesNew = new ArrayList<Grade>();
		gradesNew.add(this.grade1);
		gradesNew.add(this.grade2);
		
		this.dropLowestStrategy.calculate(this.grades);
		
		verify(this.mockStrategy, times(1)).calculate(gradesNew);
	}

	/**
	 * test trying to drop lowest grade with many grades and lowest is middle
	 */
	@Test
	public void canDropWhenLowestIsInMiddle() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade0);
		this.grades.add(this.grade2);

		ArrayList<Grade> gradesNew = new ArrayList<Grade>();
		gradesNew.add(this.grade1);
		gradesNew.add(this.grade2);
		
		this.dropLowestStrategy.calculate(this.grades);
		
		verify(this.mockStrategy, times(1)).calculate(gradesNew);
	}

	/**
	 * test trying to drop lowest grade with many same low grades
	 */
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade0);
		this.grades.add(this.grade2);
		this.grades.add(this.grade0);

		ArrayList<Grade> gradesNew = new ArrayList<Grade>();
		gradesNew.add(this.grade1);
		gradesNew.add(this.grade2);
		gradesNew.add(this.grade0);
		
		this.dropLowestStrategy.calculate(this.grades);
		
		verify(this.mockStrategy, times(1)).calculate(gradesNew);
	}
}