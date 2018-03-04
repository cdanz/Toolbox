/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_lab6;

/**
 * Various sorting algorithms. All accept an unsorted int array and return
 * the array sorted in accending order. 
 * @author danzc
 *
 */
public class Sort {
    private static int[] array;
    private static int[] tempMergArr;
    private static int length;
	
	/**
	 * Sorts a given array by insertion sort. 
	 * @param sortMe 				An unsorted array of integers.
	 * @return sortMe				Array sorted in non-decreasing order.
	 */
	public static int[] InsertionSort(int[] sortMe) {
		for (int i = 1; i < sortMe.length; i++) {
			int elem = sortMe[i];
			int index = i - 1;
			while (index >= 0 && sortMe[index] > elem) {
				sortMe[index + 1] = sortMe[index];
				index--;
			}
			sortMe[index + 1] = elem;
		}
		return sortMe;
	}
	
	/**
	 * Sorts a given array by selection sort
	 * @param sortMe				An unsorted array of integers.
	 * @return sortMe			Array sorted in non-decreasing order.
	 */
	public static int[] SelectionSort(int[] sortMe) {
		for (int i = 0; i < sortMe.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < sortMe.length; j++) {
				if (sortMe[j] < sortMe[min])
					min = j;
			}
			int temp = sortMe[i];
			sortMe[i] = sortMe[min];
			sortMe[min] = temp;
		}
		return sortMe;
	}
			
	/**
	 * Sorts a given array by bubble sort
	 * @param sortMe 				An unsorted array of integers.
	 * @return sortMe				Array sorted in non-decreasing order.
	 */
	public static int[] BubbleSort(int[] sortMe) {
		for (int i = 0; i < sortMe.length - 1; i++) {
			for (int j = 0; j < sortMe.length - 1 - i; j++) {
				if (sortMe[j + 1] < sortMe[j]) {
					int temp = sortMe[j];
					sortMe[j] = sortMe[j + 1];
					sortMe[j + 1] = temp;
				}
			}
		}
		return sortMe;
	}
     
    public static void MergeSort(int[] sortMe) {
        array = sortMe;
        length = sortMe.length;
        tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private static void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
					
	/**
	 * Sorts a given array by quick sort
	 * @param sortMe 				An unsorted array of integers.
	 * @param left					left bound of array
	 * @param right					right bound of array
	 * @return sortMe				Array sorted in non-decreasing order.
	 */
	public static int[] QuickSort(int[] sortMe, int left, int right) {
		if(left < right) {
			int q = Partition(sortMe, left, right);
			QuickSort(sortMe, left, q-1);
			QuickSort(sortMe, q + 1, right);
		}
		return sortMe;
	}
	
	/**
	 * Takes the last element as the pivot and puts pivot element
	 * in its proper position in a sorted array and places all smaller 
	 * elements to the left, all greater to the right.
	 * @param sortMe					Array to sort
	 * @param left					Left bound of array
	 * @param right					Right bound of array
	 * @return i						Index of partition.
	 */
	private static int Partition(int[] sortMe, int left, int right) {
		int pivot = sortMe[right]; 
		int i = left - 1; 
		for (int j = left; j <= right - 1; j++) { 
			if (sortMe[j] <= pivot) { 
				i++; 
				int temp = sortMe[i];
				sortMe[i] = sortMe[j];
				sortMe[j] = temp;
			}
		}
		int temp2 = sortMe[right];
		sortMe[right] = sortMe[i + 1];
		sortMe[i + 1] = temp2;
		return i + 1;
	}
	
	public static void HeapSort(int sortMe[])
    {
        int n = sortMe.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(sortMe, n, i);
        for (int i=n-1; i>=0; i--)
        {
            int temp = sortMe[0];
            sortMe[0] = sortMe[i];
            sortMe[i] = temp;
            heapify(sortMe, i, 0);
        }
    }
	
    private static void heapify(int sortMe[], int n, int i)
    {
        int largest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;
        if (l < n && sortMe[l] > sortMe[largest])
            largest = l;
        if (r < n && sortMe[r] > sortMe[largest])
            largest = r;
        if (largest != i)
        {
            int swap = sortMe[i];
            sortMe[i] = sortMe[largest];
            sortMe[largest] = swap;
            heapify(sortMe, n, largest);
        }
    }
}
