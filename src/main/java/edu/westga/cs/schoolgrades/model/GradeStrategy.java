package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Interface for all grade strategies
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public interface GradeStrategy {

	/**
	 * Method used for to retrieve the grade subtotal value as a double
	 * 
	 * @param grades	grades to use for subtotal
	 * @return double	grade subtotal value
	 */
	double getSubtotal(ArrayList<Grade> grades);
}