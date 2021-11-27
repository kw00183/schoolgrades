package edu.westga.cs.schoolgrades.model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for CompositeGrade class add method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestCompositeGradeAdd {

	private CompositeGrade composite;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	/**
	 * setup method run before each test
	 */
	@BeforeEach
	public void setup() {
		this.composite = new CompositeGrade(mock(GradeCalculationStrategy.class));
		this.grade0 = mock(Grade.class);
		when(this.grade0.getValue()).thenReturn(10.00);
		this.grade1 = mock(Grade.class);
		when(this.grade1.getValue()).thenReturn(20.00);
		this.grade2 = mock(Grade.class);
		when(this.grade2.getValue()).thenReturn(30.00);
	}

	/**
	 * test adding one grade
	 */
	@Test
	public void canAddOneGrade() {
		this.composite.add(this.grade0);
		List<Grade> grades = this.composite.getGrades();
		assertEquals(1, grades.size());
		assertEquals(this.grade0, grades.get(0));
	}

	/**
	 * test adding many grades
	 */
	@Test
	public void canAddManyGrades() {
		this.composite.add(this.grade0);
		this.composite.add(this.grade1);
		this.composite.add(this.grade2);
		List<Grade> grades = this.composite.getGrades();
		assertEquals(3, grades.size());
		assertEquals(this.grade0, grades.get(0));
		assertEquals(this.grade1, grades.get(1));
		assertEquals(this.grade2, grades.get(2));
	}

	/**
	 * test add of null grade
	 */
	@Test
	public void shouldNotAddNullGrade() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.composite.add(null);
		});
	}
}