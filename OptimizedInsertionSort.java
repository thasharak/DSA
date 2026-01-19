/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

import java.util.Arrays;

/**
 *
 * @author kulat
 */
public class OptimizedInsertionSort {

        // Optimized Insertion Sort with binary search
    public static void optimizedInsertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            
            // Optimization 1: Use binary search to find insertion position
            int insertionPoint = binarySearch(arr, key, 0, i - 1);
            
            // Optimization 2: Shift elements using System.arraycopy
            if (insertionPoint != i) {
                System.arraycopy(arr, insertionPoint, arr, insertionPoint + 1, i - insertionPoint);
                arr[insertionPoint] = key;
            }
        }
    }
    
    // Binary search to find insertion point
    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    // Alternative: Traditional insertion sort with sentinel optimization
    public static void insertionSortWithSentinel(int[] arr) {
        int n = arr.length;
        
        // Optimization 3: Find minimum and place at beginning (sentinel)
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        // Swap minimum to first position
        int temp = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = temp;
        
        // Now sort from index 1 to n-1 (skipping bounds check)
        for (int i = 2; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
      // Most optimized version with reduced swaps
    public static void optimizedInsertionSortV2(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Find position and shift in one pass
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Optimization: Only assign if position changed
            if (j + 1 != i) {
                arr[j + 1] = key;
            }
        }
    }
    public static void main(String[] args) {
               // Test array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90, 5, 3, 1};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        
        System.out.println("Original array: " + Arrays.toString(arr1));
        
        // Test optimized version with binary search
        optimizedInsertionSort(arr1);
        System.out.println("Sorted (Binary Search Optimization): " + Arrays.toString(arr1));
        
        // Test sentinel optimization
        insertionSortWithSentinel(arr2);
        System.out.println("Sorted (Sentinel Optimization): " + Arrays.toString(arr2));
        
        // Test reduced swaps optimization
        optimizedInsertionSortV2(arr3);
        System.out.println("Sorted (Reduced Swaps Optimization): " + Arrays.toString(arr3));
        
        // Performance comparison
        System.out.println("\n=== Performance Test ===");
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int)(Math.random() * 100000);
        }
        int[] testArray = largeArray.clone();
        
        long startTime = System.nanoTime();
        optimizedInsertionSortV2(testArray);
        long endTime = System.nanoTime();
        
        System.out.println("Time taken for 10,000 elements: " + 
                          (endTime - startTime) / 1000000.0 + " ms");
    }
    
}
