package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for DropLowestStrategy class calculate method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestDropLowestStrategyCalculate {

	private static final double DELTA = 0.001;

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;

	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	private List<Grade> grades;

	/**
	 * setup method run before each test
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.grade0 = new SimpleGrade(10);
		this.grade1 = new SimpleGrade(20);
		this.grade2 = new SimpleGrade(30);

		this.grades = new ArrayList<Grade>();

		this.childStrategy = new SumOfGradesStrategy();
		this.dropLowestStrategy = new DropLowestStrategy(this.childStrategy);
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
		assertEquals(0, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}

	/**
	 * test trying to drop lowest grade with one grade
	 */
	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		this.grades.add(this.grade0);
		assertEquals(this.grade0.getValue(),
				this.dropLowestStrategy.calculate(this.grades), DELTA);
	}

	/**
	 * test trying to drop lowest grade with many grades
	 */
	@Test
	public void canDropWhenLowestIsFirst() {
		this.grades.add(this.grade0);
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}

	/**
	 * test trying to drop lowest grade with many grades and lowest is last
	 */
	@Test
	public void canDropWhenLowestIsLast() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		this.grades.add(this.grade0);
		assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}

	/**
	 * test trying to drop lowest grade with many grades and lowest is middle
	 */
	@Test
	public void canDropWhenLowestIsInMiddle() {
		this.grades.add(this.grade1);
		this.grades.add(this.grade0);
		this.grades.add(this.grade2);
		assertEquals(50, this.dropLowestStrategy.calculate(this.grades), DELTA);
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
		assertEquals(60, this.dropLowestStrategy.calculate(this.grades), DELTA);
	}
}