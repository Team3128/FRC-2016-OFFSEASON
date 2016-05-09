package org.usfirst.frc.team3128.lib.util;


/**
 * Wrapper around Java's math functions.
 * 
 * You might argue that it's unnecessary, but it does handle radian to degree conversion, and have a couple extra functions
 * like LogN and Clamp.
 * 
 * @author Garrison, Jamie
 *
 */
public class NarMath {
	
	public static final double PI = 3.14159265358979323846;

	public static final double degToRad = PI / 180.0; 
	public static final double radToDeg = 180.0 / PI; 
	
	/**
	 * Returns the absolute value of d.
	 * @param d
	 */
	//NOTE: Exists in Java's built-in math
	public static double abs(double d) {
		if (d < 0) {
			d = -d;
		}
		return d;
	}
	
	/**
	 * Returns the arc-cosine of d - the angle in degrees whose cosine is d.
	 * @param d
	 */
	public static double acos(double d) {
		return Math.acos(d) * radToDeg;
	}
	
	/**
	 * Compares two floating point values to see if they are similar.
	 *  
	 *  Tolerance: .001 (hundredths place)
	 * @param a
	 * @param b
	 */
	public static boolean approximately(double a, double b) {
		return true;
	}
	
	/**
	 * Returns the arc-sine of d - the angle in degrees whose sine is d.
	 * @param d
	 */
	public static double asin(double d) {
		return Math.asin(d) * radToDeg;
	}
	
	/**
	 * Returns the arc-tangent of d - the angle in degrees whose tangent is d.
	 * @param d
	 */
	public static double atan(double d) {
		return Math.atan(d) * radToDeg;
	}
	
	/**
	 * Returns the angle in degrees whose Tan is y/x.
	 * 
	 * Takes the X and Y values separately so that the result can be placed in the correct quadrant.
	 * @param x
	 * @param y
	 */
	public static double atan2(double x, double y) {
		return Math.atan2(y, x) * radToDeg;
	}
	
	/**
	 * Returns the smallest integer greater to or equal to d.
	 * 
	 * Throws if the result cannot be represented by an integer.
	 * @param d
	 */
	public static int ceil(double d) {
		double ceilinged = Math.ceil(d);
		if(!Double.isFinite(ceilinged) || ceilinged > Integer.MAX_VALUE)
		{
			throw new IllegalArgumentException("The provided double cannot be represented by an int");
		}
		
		return (int)ceilinged;
	}
	
	/**
	 * Returns the largest integer smaller to or equal to d.
	 * 
	 * Throws if the result cannot be represented by an integer.
	 * @param d
	 */
	public static int floor(double d)
	{
		double floored = Math.floor(d);
		   
		if(!Double.isFinite(floored) || floored > Integer.MAX_VALUE)
		{
			throw new IllegalArgumentException("The provided double cannot be represented by an int");
		}
		   
		return (int)floored;
	}
	
	/**
	 * Clamps a value between a minimum double and maximum double value.
	 * @param d
	 * @param min
	 * @param max
	 */
	public static double clamp(double d, double min, double max) {
		if (d > max) {
			d = max;
		}
		else if (d < min) {
			d = min;
		}
		return d;
	}
	
	/**
	 * Clamps value between 0 and 1 and returns value.
	 * @param d
	 */
	public static double clamp01(double d) {
		clamp(d, 0, 1);
		return d;
	}
	
	/**
	 * Clamps value between positive and negative 1 and returns value.
	 * 
	 * Great for motor powers!
	 * @param d
	 */
	public static double clampPosNeg1(double d) {
		clamp(d, -1, 1);
		return d;
	}

	/**
	 * Returns the power of 2 closest to the argument.
	 * @param d
	 */
	public static int closestPowerOf2(double d) {
		return round(log(2, d));
	}
	
	/**
	 * Returns the cosine of angle d in degrees.
	 * @param d
	 */
	public static double cos(double d) {
		return Math.cos(degToRad *  d);
	}
	
	/**
	 * Returns the sine of angle d in degrees.
	 * @param d
	 */
	public static double sin(double d) {
		return Math.sin(degToRad *  d);
	}
	
	/**
	 * Returns the tangent of angle d in degrees.
	 * @param d
	 */
	public static double tan(double d) {
		return Math.tan(degToRad *  d);
	}
	
	/**
	 * Calculates the shortest difference between two given angles given in degrees.
	 * @param a
	 * @param b
	 */
	public static double deltaAngle(double a, double b) {
		double result = Math.abs(b-a);
		if (result > 180) {
			result = 360 - result;
		}
		return result;
	}
	

	
	/**
	 *  Calculates the linear parameter t that produces the interpolated value within the range [a, b].
	 * @param d
	 * @return
	 */
	public static double inverseLerp(double interpolatedVal, double rangeMin, double rangeMax) {
		return (interpolatedVal - rangeMin) / (rangeMax - rangeMin);
	}
	
	/**
	 * Returns true if the integer is a power of two.
	 * @param i
	 */
	public static boolean isPowerOf2(int i) 
	{
		while(i % 2 == 0)
		{
			i /= 2;
			
			if(i == 1)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Linearly intERPolates between a and b by t.
	 * 
	 * t should be between 0 and 1.
	 */
	public static double lerp(double rangeMin, double rangeMax, double t) {
		return rangeMin + t * (rangeMax - rangeMin);
	}
	
	/**
	 * Same as Lerp but makes sure the values interpolate correctly when they wrap around 360 degrees.
	 */
	public static double lerpAngle(double rangeMin, double rangeMax, double t) {
		return normalizeAngle(lerp(rangeMin, rangeMax, t));
	}
	
	/**
	 * Returns the exponent needed to make e (Euler's number) the given number.
	 * @param d
	 */
	public static double logE(double d) {
		return Math.log(d);
	}
	
	/**
	 * Returns the exponent needed to make 10 the given number.
	 * @param d
	 */
	public static double log10(double d) {
		return Math.log10(d);
	}
	
	//calculate this once here for speed
	static final private double log2Base10 = Math.log10(2);
	
	/**
	 * Returns the exponent needed to make 2 the given number.
	 * @param d
	 */
	public static double log2(double d) {
		return Math.log10(d) / log2Base10;
	}
	
	/**
	 * Returns the exponent needed to make the base the given number.
	 * @param d
	 */
	public static double log(double base, double num) {
		return Math.log(num) / Math.log(base);
	}
	
	/**
	 * Returns largest of two doubles.
	 * @param d
	 */
	public static double max(double num1, double num2) {
		return Math.max(num1, num2);
	}
	
	/**
	 * Returns largest of two integers.
	 * @param d
	 */
	public static int max(int num1, int num2) {
		return Math.max(num1, num2);
	}
	
	
	/**
	 * Returns largest of two Comparable objects.
	 * @param d
	 */
	public static <T extends Comparable<T>> T max(T thing1, T thing2) 
	{
		return ((Comparable<T>)thing1).compareTo(thing2) >= 1 ? thing1 : thing2;
	}
	
	
	/**
	 * Returns smallest of two doubles.
	 * @param d
	 */
	public static double min(double num1, double num2) {
		return Math.min(num1, num2);
	}
	
	/**
	 * Returns smallest of two integers.
	 * @param d
	 */
	public static int min(int num1, int num2) {
		return Math.min(num1, num2);
	}
	
	
	/**
	 * Returns smallest of two Comparable objects.
	 * @param d
	 */
	public static <T extends Comparable<T>> T min(T thing1, T thing2) 
	{
		return ((Comparable<T>)thing1).compareTo(thing2) >= 1 ? thing2 : thing1;
	}
	
	/** 
	 * Returns the next positive power of two greater than the value.
	 * 
	 * If d is between 1/2 and 0, returns 1.
	 * @param d
	 * @return
	 */
	public static int nextPosPowerOfTwo(double d) 
	{
		if(d <= 0)
		{
			throw new IllegalArgumentException("Invalid number to find the next power of two of: " + d);
		}
				
		int lowerPowOfTwo = floor(log2(d));
		
		if(lowerPowOfTwo < 0)
		{
			return 1;
		}
		
		return intPow(2, lowerPowOfTwo + 1);
	}
	
	/** 
	 * Returns the next power of two greater than the value.
	 * Works for values between 1 and 0.
	 * @param d
	 * @return
	 */
	public static double nextPowerOfTwo(double d) 
	{
		if(d <= 0)
		{
			throw new IllegalArgumentException("Invalid number to find the next power of two of: " + d);
		}
				
		return pow(2, floor(log2(d)) + 1);
	}
	
	/**
	 * Returns d raised to power p.
	 * @param d
	 * @param p
	 */
	public static double pow(double d, double p) {
		return Math.pow(d, p);
	}
	
	/**
	 * Raises an integer to a integer power >= 0.
	 * 
	 * Much more lightweight than the regular function, but also more restricted
	 */
	public static int intPow(int number, int power)
	{
		int result = 1;
		for(; power >= 1; --power)
		{
			result *= number;
		}
		
		return result;
	}
	
	/**
	 * Returns d rounded to the nearest integer.
	 * @param d
	 */
	public static int round(double d) {
		return (int)Math.round(d);
	}
	
	/**
	* Standard-ish sign function
	* @param n
	* @return
	*/
	public static double sgn(double n)
	{
		if(n == 0)
		{
			return 0;
		}
		 
		return Math.abs(n) / n;
	
	}
   
	public static int sgn(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		
		return Math.abs(n) / n;
	}
	
	/**
	 * Returns square root of d.
	 * @param d
	 */
	public static double sqrt(double d) {
		return Math.sqrt(d);
	}
	
	
	/**
	 * If the abs value of the number is less than the threshold, return 0, otherwise return the number
	 * @param value
	 * @param threshold
	 * @return
	 */
	public static double thresh(double value, double threshold)
	{
		if(Math.abs(value) < Math.abs(threshold))
		{
			return 0;
		}
		return value;
	}
	
	/**
	 * If the abs value of the number is less than the threshold, return 0, otherwise return the number
	 * @param value
	 * @param threshold
	 * @return
	 */
	public static float thresh(float value, float threshold)
	{
		if(Math.abs(value) < Math.abs(threshold))
		{
			return 0;
		}
		return value;
	}
	
	/**
	 * Converts linear distance to angular.
	 * 
	 * For example, if a wheel was touching a surface, and the surface moved x cm, then the wheel turned LinearDistToAngular(x) degrees.
	 * @param cm
	 * @param wheelCircumference the circumference of the circle
	 * @return
	 */
	public static double linearDistToAngular(double d, double circumference)
	{
		return (360 / circumference) * d;
	}
	
	/**
	 * Converts angular distance to linear.
	 * 
	 * For example, if a wheel was touching a surface, and the wheel turned y degrees, then the surface moved AngularDistToLinear(y) degrees.
	 * @param cm
	 * @param wheelCircumference the circumference of the circle
	 * @return
	 */
	public static double angularDistToLinear(double deg, double circumference)
	{
		return (deg / 360) * circumference;
	}
	
	
	/**
	 * Squares the argument.  Easier than Math.pow(number, 2).
	 * @param number
	 * @return
	 */
	public static double square(double number)
	{
		return number * number;
	}
	
	/**
	 * Squares the argument.  Easier than NMath.IntPow(number, 2).
	 * @param number
	 * @return
	 */
	public static int square(int number)
	{
		return number * number;
	}
	

	/**
	* Limits the angle to between 0 and 359 degrees for all math. All angles
	* should be normalized before use.
	* <p/>
	* @param angle the angle to be normalized
	* <p/>
	* @return the normalized angle on [0, 359]
	*/
	public static double normalizeAngle(double angle)
	{
	    double theta = ((angle % 360) + 360) % 360;
	    return theta;
	}
}
