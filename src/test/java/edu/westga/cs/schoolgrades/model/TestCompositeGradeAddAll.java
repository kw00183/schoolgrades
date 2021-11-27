package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for CompositeGrade class addAll method
 * 
 * @author lewisb
 * @version cs6241
 */
public class TestCompositeGradeAddAll {

	private CompositeGrade composite;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	private List<Grade> list;

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
		this.list = new ArrayList<Grade>();
	}

	/**
	 * test for add of null list of grades
	 */
	@Test
	public void shouldNotAddNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.composite.addAll(null);
		});
	}

	/**
	 * test for add of empty list of grades
	 */
	@Test
	public void shouldAddEmptyList() {
		this.composite.addAll(new ArrayList<Grade>());
		assertTrue(this.composite.getGrades().isEmpty());
	}

	/**
	 * test for add of one grade in list
	 */
	@Test
	public void shouldAddOneElementList() {
		this.list.add(this.grade0);
		this.composite.addAll(this.list);
		List<Grade> actual = this.composite.getGrades();
		assertEquals(1, actual.size());
		assertEquals(this.grade0, actual.get(0));
	}

	/**
	 * test for add of many grades in list
	 */
	@Test
	public void shouldAddManyElementsList() {
		this.list.add(this.grade0);
		this.list.add(this.grade1);
		this.list.add(this.grade2);
		this.composite.addAll(this.list);
		List<Grade> actual = this.composite.getGrades();
		assertEquals(3, actual.size());
		assertEquals(this.grade0, actual.get(0));
		assertEquals(this.grade1, actual.get(1));
		assertEquals(this.grade2, actual.get(2));
	}
}