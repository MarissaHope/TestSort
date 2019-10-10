// Modified by:    John Cade
// Date:           September 5, 2015
// Last modified:  September 2, 2017

// Commented out code that is not used.  Modified the mergeSort 
// method to make the more efficient mergeSort2 and mergeSort3 
// methods.

// import java.util.Arrays;

/**
 * Sorting demonstrates sorting and searching on an array 
 * of objects.
 *
 * @author Lewis and Chase
 * @version 4.0 
 */
public class Sorting 
{
    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void selectionSort(T[] data)
    {
        int min;
        // T temp;
        
        for (int index = 0; index < data.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < data.length; scan++)
                if (data[scan].compareTo(data[min])<0)
                    min = scan;
			
            swap(data, min, index);
        }
    }  // selectionSort
	
	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	// private 
	public static <T extends Comparable<T>> 
		void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}  // swap
	
    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void insertionSort(T[] data)
    {
        for (int index = 1; index < data.length; index++)
        {
            T key = data[index];
            int position = index;
			
            // shift larger values to the right 
            while (position > 0 && data[position-1].compareTo(key) > 0)
            {
                data[position] = data[position-1];
                position--;
            }
			
            data[position] = key;
        }
    }  // insertionSort
	
    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void bubbleSort(T[] data)
    {
        int position, scan;
        // T temp;
		
        for (position =  data.length - 1; position >= 0; position--)
        {
            for (scan = 0; scan <= position - 1; scan++)
            {
                if (data[scan].compareTo(data[scan+1]) > 0)
                    swap(data, scan, scan + 1);
            }
        }
    }  // bubbleSort

//***************************************************************

 	/**
 	 * Sorts the specified array of objects using the quick sort algorithm.
 	 * 
 	 * @param data the array to be sorted
 	 */
 	public static <T extends Comparable<T>> 
 		void quickSort(T[] data)
 	{
 		quickSort(data, 0, data.length - 1);
 	}  // quickSort
 	
 	/**
 	 * Recursively sorts a range of objects in the specified array using the
 	 * quick sort algorithm. 
 	 * 
 	 * @param data the array to be sorted
 	 * @param min  the minimum index in the range to be sorted
 	 * @param max  the maximum index in the range to be sorted
 	 */
 	private static <T extends Comparable<T>> 
 		void quickSort(T[] data, int min, int max)
 	{
 		if (min < max)
 		{
 			// create partitions
 			int indexofpartition = partition(data, min, max);
 			
 			// sort the left partition (lower values)
 			quickSort(data, min, indexofpartition - 1);
 			
 			// sort the right partition (higher values)
 			quickSort(data, indexofpartition + 1, max);
 		}
 	}  // quickSort
 	
 	/**
 	 * Used by the quick sort algorithm to find the partition.
 	 * 
 	 * @param data the array to be sorted
 	 * @param min  the minimum index in the range to be sorted
 	 * @param max  the maximum index in the range to be sorted
 	 */
 	private static <T extends Comparable<T>> 
 		int partition(T[] data, int min, int max)
 	{
 		T partitionelement;
 		int left, right;
 		int middle = (min + max) / 2;
 		
 		// use the middle data value as the partition element
 		partitionelement = data[middle];
 		// move it out of the way for now
 		swap(data, middle, min);
 		
 		left = min;
 		right = max;
 		
 		while (left < right)
 		{
 			// search for an element that is > the partition element
 			while (left < right && data[left].compareTo(partitionelement) <= 0)
 				left++;
 			
 			// search for an element that is < the partition element
 			while (data[right].compareTo(partitionelement) > 0)
 				right--;
 			
 			// swap the elements
 			if (left < right)
 				swap(data, left, right);
 		}
 		
 		// move the partition element into place
 		swap(data, min, right);
 		
 		return right;
 	}  // partition

//***************************************************************

    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     *
     * @param data the array to be sorted
     */
	public static <T extends Comparable<T>>
		void mergeSort(T[] data)
	{
		mergeSort(data, 0, data.length - 1);
	}  // mergeSort
	
    /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min  the index of the first element 
     * @param max  the index of the last element
     */
	private static <T extends Comparable<T>>
		void mergeSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid+1, max);
			merge(data, min, mid, max);
		}
	}  // mergeSort
	
	/**
     * Merges two sorted subarrays of the specified array.
     *
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray 
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>>
		void merge(T[] data, int first, int mid, int last)
	{
		T[] temp = (T[])(new Comparable[data.length]);
		
		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
   }  // merge

//***************************************************************

	// The mergeSort2 method is a modification of the mergeSort 
	// method so that the temporary array temp is created only 
	// once, instead of once for every merge.  Testing shows that 
	// mergeSort2 is approximately 50 times faster than the
	// original mergeSort method. 

   /**
    * Sorts the specified array of objects using the merge sort
    * algorithm.
    *
    * @param data the array to be sorted
    */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void mergeSort2(
		T[] data)
	{
		T[] temp = (T[]) (new Comparable[data.length]);

		mergeSort2(data, temp, 0, data.length - 1);
	}  // mergeSort2
	
   /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
    *
    * @param data the array to be sorted
    * @param min  the index of the first element 
    * @param max  the index of the last element
    */
	private static <T extends Comparable<T>> void mergeSort2(
		T[] data, T[] temp, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort2(data, temp, min, mid);
			mergeSort2(data, temp, mid+1, max);
			merge2(data, temp, min, mid, max);
		}
	}  // mergeSort2
	
	/**
    * Merges two sorted subarrays of the specified array.
    *
    * @param data the array to be sorted
    * @param first the beginning index of the first subarray 
    * @param mid the ending index fo the first subarray
    * @param last the ending index of the second subarray
    */
	private static <T extends Comparable<T>> void merge2(T[] data, 
		T[] temp, int first, int mid, int last)
	{
		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
  }  // merge2

//***************************************************************

	// The mergeSort3 method is a modification of the mergeSort2
	// method to eliminate unnecessary copying in the merge2 
	// method.  Testing indicates that this yields little or no
	// performance improvement over that of mergeSort2.

   /**
    * Sorts the specified array of objects using the merge sort
    * algorithm.
    *
    * @param data the array to be sorted
    */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void mergeSort3(
		T[] data)
	{
		T[] temp = (T[]) (new Comparable[data.length]);
		
		mergeSort3(data, temp, 0, data.length - 1);
	}  // mergeSort3
	
   /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
    *
    * @param data the array to be sorted
    * @param min  the index of the first element 
    * @param max  the index of the last element
    */
	private static <T extends Comparable<T>> void mergeSort3(
		T[] data, T[] temp, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			
			mergeSort3(data, temp, min, mid);
			mergeSort3(data, temp, mid+1, max);
			merge3(data, temp, min, mid, max);
		}
	}  // mergeSort3
	
	/**
    * Merges two sorted subarrays of the specified array.
    *
    * @param data the array to be sorted
    * @param first the beginning index of the first subarray 
    * @param mid the ending index fo the first subarray
    * @param last the ending index of the second subarray
    */
	private static <T extends Comparable<T>> void merge3(T[] data, 
		T[] temp, int first, int mid, int last)
	{
		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array;
			// also index in data array when shifting rest of first
			// subarray
		int lastTemp;
			// end index in the temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		lastTemp = index - 1;
		
		// Shift any remaining elements from first subarray into  
		// the proper locations in the original array.  The 
		// shifting must be done starting from the highest index of 
		// the array range to be shifted.  Starting from the lowest 
		// index can overwrite items at the upper end of the range 
		// with items from the lower end before the upper end items 
		// have been shifted.
		index = last;
		while (last1 >= first1) {
			data[index] = data[last1];
			last1--;
			index--;		
		}
		
		// It is not necessary to copy any remaining elements from 
		// the second subarray into the temp array.  Any such 
		// elements are already in the proper locations in the 
		// original array.
		
		//  Copy merged data into original array
		for (index = first; index <= lastTemp; index++)
			data[index] = temp[index];
  }  // merge3

}  // class Sorting