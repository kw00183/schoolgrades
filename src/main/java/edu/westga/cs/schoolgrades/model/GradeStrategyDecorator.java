package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Class for the strategy decorator to drop the lowest grade all the grades
 * 
 * @author Kim Weible
 * @version cs6241 Fall
 */
public abstract class GradeStrategyDecorator implements GradeStrategy {

	public void doAdditional() {};
	
	@Override
	public double getSubtotal(ArrayList<Grade> grades) {
		// TODO Auto-generated method stub
		return 0;
	}
}