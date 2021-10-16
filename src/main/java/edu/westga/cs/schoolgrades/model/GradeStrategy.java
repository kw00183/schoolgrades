package edu.westga.cs.schoolgrades.model;

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
	 * @return double as the grade subtotal value
	 */
	double getSubtotal();
}