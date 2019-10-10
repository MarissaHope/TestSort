/*
 * Modified By: Marissa Tucker
 * Date: September 11, 2017
 * Last Modified: September 13,2017
 * CS 355
 * Test Sort is a program that records how long it takes for 
 * sorting algorithms to sort a list.
 */
 import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestSort {
	public static void main(String[] args) {
		
		// Creates a random object named rand
		Random rand = new Random(System.currentTimeMillis());
		// Creates the keyScan scanner object
		Scanner keyScan = new Scanner(System.in);
		// User specifies list length
		System.out.println("Enter list length: ");
		// Records the list length specified by the user 
		Integer listLength = keyScan.nextInt();
		// Closes scanner
		keyScan.close();
		
		// Creates an array the length specified by the user
		Integer[] list = new Integer[listLength];
		
		// Generates a list of random numbers of the user specified length 
		for(int i = 0; i <= listLength - 1; i++) {
			list[i] = rand.nextInt(listLength - 1);	
		}
		
		// Creates 7 individual copies of the array list
		Integer[] arrayCopy1 = Arrays.copyOf(list, list.length);
		Integer[] arrayCopy2 = Arrays.copyOf(list, list.length);
		Integer[] arrayCopy3 = Arrays.copyOf(list, list.length);
		Integer[] arrayCopy4 = Arrays.copyOf(list, list.length);
		Integer[] arrayCopy5 = Arrays.copyOf(list, list.length);
		Integer[] arrayCopy6 = Arrays.copyOf(list, list.length);
		Integer[] arrayCopy7 = Arrays.copyOf(list, list.length);
		 	
		
		// Records startTime
		long startTime = System.nanoTime();
		//Executes the selectionSort method
		Sorting.selectionSort(arrayCopy1);
		// Records endTime
		long endTime = System.nanoTime();
		// Calculates total sorting time
		double totalTime = (endTime - startTime) / 1000000000.0;
		// Prints sorting time
		System.out.println("Selection Sort: " + totalTime  + " seconds");
		
		// Records startTime
		startTime = System.nanoTime();
		//Executes the insertionSort method
		Sorting.insertionSort(arrayCopy2);
		// Records endTime
		endTime = System.nanoTime();
		// Calculates total sorting time
		totalTime = (endTime - startTime) / 1000000000.0;
		// Prints sorting time
		System.out.println("Insertion Sort: " + totalTime + " seconds");
				
		// Records startTime
		startTime = System.nanoTime();
		//Executes the bubbleSort method
		Sorting.bubbleSort(arrayCopy3);
		// Records endTime
		endTime = System.nanoTime();
		// Calculates total sorting time
		totalTime = (endTime - startTime) / 1000000000.0;
		// Prints sorting time
		System.out.println("Bubble Sort: " + totalTime + " seconds");
				
		// Records startTime
		startTime = System.nanoTime();
		//Executes the quickSort method
		Sorting.quickSort(arrayCopy4);
		// Records endTime
	    endTime = System.nanoTime();
	    // Calculates total sorting time
		totalTime = (endTime - startTime) / 1000000000.0;
		// Prints sorting time
		System.out.println("Quick Sort: " + totalTime + " seconds");
		
		// Records startTime
		startTime = System.nanoTime();
		//Executes the mergeSort method
		Sorting.mergeSort(arrayCopy5);	
		// Records endTime
		endTime = System.nanoTime();
		// Calculates total sorting time
		totalTime = (endTime - startTime) / 1000000000.0;
		// Prints sorting time
		System.out.println("Merg Sort: " + totalTime  + " seconds");
		
		// Records startTime
		startTime = System.nanoTime();
		//Executes the mergeSort2 method
		Sorting.mergeSort2(arrayCopy6);
		// Records endTime
		endTime = System.nanoTime();
		// Calculates total sorting time
		totalTime = (endTime - startTime) / 1000000000.0;
		// Prints sorting time
		System.out.println("Merg Sort2: " + totalTime  + " seconds");
		
		// Records startTime
		startTime = System.nanoTime();
		//Executes the mergeSort3 method
		Sorting.mergeSort3(arrayCopy7);
		// Records endTime
		endTime = System.nanoTime();
		// Calculates total sorting time
		totalTime = (endTime - startTime) / 1000000000.0;
		// Prints sorting time
		System.out.println("Merg Sort3: " + totalTime  + " seconds");
	}
}
