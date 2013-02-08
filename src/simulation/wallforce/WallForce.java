package simulation.wallforce;

import java.util.List;

import simulation.EnvironmentalForce;
import simulation.Mass;
import util.Vector;
import view.Canvas;

/**
 * Implements the wall environmental force on an array of masses.  
 * Abstract class that represents a general wall force, since
 * all wall forces have a magnitude and an exponent. Daughter classes
 * dictate direction and distance(indirectly magnitude) of the force
 * to be applied. 
 * 
 * 
 * @author Francesco Agosti
 *
 */
public abstract class WallForce extends EnvironmentalForce {
	protected static final Double MAGNITUDE = 10.0;
	protected static final Double EXPONENT = 0.0;
	
	protected double myMagnitude;
	protected double myExponent;
	protected double myAngle;
	protected double myLowerWallPosition;
	protected double myRightWallPosition;

	
	public WallForce(double magnitude, double exponent){
		super();
		myMagnitude = magnitude;
		myExponent = exponent;
	}

	@Override
	/**
	 * Cycles through a list of Masses, applying the constructed wall force to each 
	 * of these masses
	 */
	public void Apply(List<Mass> Masses) {
		for(Mass m : Masses){
			double distance = calculateDistance(m);
			double magnitude = myMagnitude*(Math.pow(distance, -myExponent));
			Vector force = new Vector(myAngle, magnitude);
			m.applyForce(force);
		}
	}
	
	/**
	 * Returns the distance from the appropriate wall.
	 * @param Mass m
	 * 
	 */
	protected double calculateDistance(Mass m) {
		return 0;
		
	}
	
	@Override
	/**
	 * Updates values of wall positions.
	 */
	public void update(Canvas view){
		myLowerWallPosition = view.getHeight();
		myRightWallPosition = view.getWidth();
	}
	

	

}
