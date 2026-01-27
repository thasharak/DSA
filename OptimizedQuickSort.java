/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
import java.util.Arrays;
import java.util.Random;

public class OptimizedQuickSort {
    
    // Optimized QuickSort with various improvements
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        // Use insertion sort for small subarrays
        if (high - low + 1 <= 10) {
            insertionSort(arr, low, high);
            return;
        }
        
        if (low < high) {
            // Use median-of-three for pivot selection
            int pivotIndex = medianOfThree(arr, low, high);
            swap(arr, pivotIndex, high);
            
            int partitionIndex = partition(arr, low, high);
            
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        
        // Sort low, mid, high
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        
        // mid is the median
        return mid;
    }
    
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        int[] testArray = {64, 34, 25, 12, 22, 11, 90, 88, 75, 50, 33, 67, 89, 45};
        int[] copyArray = Arrays.copyOf(testArray, testArray.length);
        
        System.out.println("Original Array: " + Arrays.toString(testArray));
        
        quickSort(testArray);
        
        System.out.println("Sorted Array: " + Arrays.toString(testArray));
        
        // Verify with Java's built-in sort
        Arrays.sort(copyArray);
        System.out.println("Java Built-in Sort: " + Arrays.toString(copyArray));
        
        // Check if arrays are equal
        System.out.println("Arrays are equal: " + Arrays.equals(testArray, copyArray));
        
        // Performance test
        System.out.println("\nPerformance Test:");
        Random random = new Random();
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = random.nextInt(100000);
        }
        
        long startTime = System.nanoTime();
        quickSort(largeArray);
        long endTime = System.nanoTime();
        
        System.out.println("Time taken to sort 10000 elements: " + 
                         (endTime - startTime) / 1_000_000.0 + " ms");
    }
}
