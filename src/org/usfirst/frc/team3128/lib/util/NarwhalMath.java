package org.usfirst.frc.team3128.lib.util;

public class NarwhalMath {
	public static float DegToRad = 0.0174533f; 
	public static float RadToDeg = 57.2958f; 
	public static float PI = 3.14159f;
	
	//TODO Returns the absolute value of f.
	//NOTE: Exists in Java's built-in math
	public static float Abs(float f) {
		if (f < 0) {
			f = -f;
		}
		return f;
	}
	
	//TODO Returns the arc-cosine of f - the angle in radians whose cosine is f.
	//NOTE: Exists in Java's built-in math
	public static float Acos(float f) {
		return f;
	}
	
	//TODO Compares two floating point values if they are similar.
	public static boolean Approximately(float a, float b) {
		return true;
	}
	
	//TODO Returns the arc-sine of f - the angle in radians whose sine is f.
	//NOTE: Exists in Java's built-in math
	public static float Asin(float f) {
		return f;
	}
	
	//TODO Returns the arc-tangent of f - the angle in radians whose tangent is f.
	//NOTE: Exists in Java's built-in math
	public static float Atan(float f) {
		return f;
	}
	
	//TODO Returns the angle in radians whose Tan is y/x.
	public static float Atan2(float x, float y) {
		return x;
	}
	
	//TODO 	Returns the smallest integer greater to or equal to f.
	public static int Ceil(float f) {
		return (int)f;
	}
	
	//TODO Clamps a value between a minimum float and maximum float value.
	public static float Clamp(float f, float min, float max) {
		if (f > max) {
			f = max;
		}
		else if (f < min) {
			f = min;
		}
		return f;
	}
	
	//TODO Clamps value between 0 and 1 and returns value.
	public static float Clamp01(float f) {
		Clamp(f, 1, 0);
		return f;
	}
	
	//TODO Returns the closest power of two value.
	public static float ClosestPowerOf2(float f) {
		int pwr = 0;
		while (Math.pow(2, pwr) < Math.pow(2, pwr - 0.5)) {
			pwr += 1;
		}
		return f;
	}
	
	//TODO Returns the cosine of angle f in radians.
	//NOTE: Exists in Java's built-in math
	public static float Cos(float f) {
		return f;
	}
	
	//TODO Calculates the shortest difference between two given angles given in degrees.
	public static float DeltaAngle(float a, float b) {
		float result = Math.abs(b-a);
		if (result > 180) {
			result = 360 - result;
		}
		return result;
	}
	
	//TODO Returns the largest integer smaller to or equal to f.
	public static int Floor(float f) {
		return (int)f;
	}
	
	//TODO Calculates the linear parameter t that produces the interpolant value within the range [a, b].
	public static float InverseLerp(float f) {
		return f;
	}
	
	//TODO Returns true if the value is power of two.
	public static boolean IsPowerOf2(int i) {
		return true;
	}
	
	//TODO Linearly interpolates between a and b by t.
	public static float Lerp(float f) {
		return f;
	}
	
	//TODO Same as Lerp but makes sure the values interpolate correctly when they wrap around 360 degrees.
	public static float LerpAngle(float f) {
		return f;
	}
	
	//TODO Returns the logarithm of a specified number in a specified base.
	//NOTE: Exists in Java's built-in math
	public static float Log(float f) {
		return f;
	}
	
	//TODO Returns the base 10 logarithm of a specified number.
	//NOTE: Exists in Java's built-in math
	public static float Log10(float f) {
		return f;
	}
	
	//TODO Returns largest of two or more values.
	//NOTE: Exists in Java's built-in math
	public static float Max(float f) {
		return f;
	}
	
	//TODO Returns the smallest of two or more values.
	//NOTE: Exists in Java's built-in math
	public static float Min(float f) {
		return f;
	}
	
	//TODO Returns the next power of two value.
	public static int NextPowerOfTwo(float f) {
		return (int)f;
	}
	
	//TODO Returns f raised to power p.
	//NOTE: Exists in Java's built-in math
	public static float Pow(float f, float p) {
		return f;
	}
	
	//TODO Returns f rounded to the nearest integer.
	//NOTE: Exists in Java's built-in math
	public static int Round(float f) {
		return (int)f;
	}
	
	//TODO Returns the sign of f.
	public static float Sign(float f) {
		return f;
	}
	
	//TODO Returns f rounded to the nearest integer.
	//NOTE: Exists in Java's built-in math
	public static float Sin(float f) {
		return f;
	}
	
	//TODO Returns square root of f.
	//NOTE: Exists in Java's built-in math
	public static float Sqrt(float f) {
		return f;
	}
	
	//TODO 	Returns the tangent of angle f in radians.
	//NOTE: Exists in Java's built-in math
	public static float Tan(float f) {
		return f;
	}
	
	/**
	 * If the abs value of the number is less than the threshold, return 0, otherwise return the number
	 * @param value
	 * @param threshold
	 * @return
	 */
	public static double Thresh(double value, double threshold)
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
	public static float Thresh(float value, float threshold)
	{
		if(Math.abs(value) < Math.abs(threshold))
		{
			return 0;
		}
		return value;
	}
}
