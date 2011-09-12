package com.Concepts.Numbers;

import java.util.*;

public class Numbers {
	
	/* Description
	 * 
	 * Write a Java program that defines an array of size 20 
	 * and assigns 20 different numbers to the array elements. 
	 * The program then finds the highest number in the array, 
	 * the lowest number, sum, average, and generates the following output.
	 * The highest number is X
	 * The lowest number is Y
	 * The sum is Z
	 * The average is A*/
	/*Author*******Date Modified*
	 * 
	 *Ebony Lewis*****9/11/2011*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] numArray = new int[20];	//Integer array of length 20
		int minVal = 0;		//Minimum value of an element
		int maxVal = 100;	//Maximum value of an element
		
		/*Assign each element in numArray the value of a random number (0-100) */
		generateRandomIntegers2(maxVal, minVal, numArray, numArray.length);
		
		/*Sort numArray in ascending order to easily retrieve lowest and highest values*/
		Arrays.sort(numArray);
		
		/*Assign corresponding variables equal to requested values*/

		//Assign value of the last element
		int highestNumber = numArray[numArray.length-1]; 
		
		//Assign value of the first element
		int lowestNumber = numArray[0];  
		
		int sumOfNumbers = getSumOfElements(numArray, numArray.length);	//Assign value of sum of elements 
		int avgOfNumbers = sumOfNumbers/numArray.length;				//Assign value of average of elements
		
		//Output all requested data to the console
		displayAllData(numArray, highestNumber, lowestNumber, sumOfNumbers, avgOfNumbers);
	}
	
	
	/*Snippet from http://www.daniweb.com/software-development/cpp/code/217203
	 * via VernonDozier [open source]
	 * Modified for personal use*/
	
	public static void generateRandomIntegers2 (int maxValLimit, int minValLimit, int [] numbers, int maxLength)
	
	// this method will generate repeated random numbers.  boolean array
	// keeps track of what numbers have been picked.  Generates another if
	// this number has already been picked.
	{
		 int range = maxValLimit - minValLimit + 1;
	     boolean[] picked =  new boolean[range];
	     
	     // initialize all to not picked
	     for (int i = 0; i < range; i++)
	         picked[i] = false;
	         
	     int value;
	     Random ranNumGen = new Random();	//Create a random number generator to populate numArray
	     
	     for (int i = 0; i < maxLength; i++)
	     {
	         value = ranNumGen.nextInt(range);
	         if (picked[value])
	             i--;  // already picked.  for-loop increments, so decrement here
	         else
	         {
	             numbers[i] = value + minValLimit;
	             picked[value] = true; // hasn't been picked yet.  Assign to array,
	                                   // flag as picked.
	         }
	     }
	}
	
	public static int getSumOfElements(int[] numbers, int maxLength)
	{
		/*Returns the sum of all of the values in the array*/
		int sum = 0;
		for(int i = 0; i < maxLength; i++)
		{
			sum+= numbers[i];
		}
		
		return sum;
	}
	
	public static void displayAllData(int[] numbers, int maxNum, int minNum, int sumNum, int avgNum)
	{
		/*Display the full array, followed by the other criteria*/
		
		System.out.println("Current Number Array: \n");
		
		//Output each element to the screen
		
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i]);
			System.out.print(" ");
		}
		
		System.out.println("\n\n The highest number is " + maxNum 
				+".\n The lowest number is " + minNum + ".\n The sum " +
						"is " + sumNum + ".\n The average is " + avgNum + ".\n");
	}
}
