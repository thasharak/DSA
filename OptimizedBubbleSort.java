/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
public class OptimizedBubbleSort {
    
    /**
     * Optimized Bubble Sort algorithm with early termination
     * @param arr Array to be sorted
     */
    public static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        System.out.println("\nStarting Optimized Bubble Sort...");
        System.out.println("Array length: " + n);
        System.out.println("----------------------------------");
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("\nPass " + (i + 1) + ":");
            System.out.print("  Before: ");
            printArray(arr);
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    System.out.println("  Swapped: " + arr[j] + " and " + arr[j + 1]);
                }
            }
            
            System.out.print("  After:  ");
            printArray(arr);
            
            // If no swapping occurred, array is already sorted
            if (!swapped) {
                System.out.println("\n  No swaps in this pass. Array is already sorted!");
                System.out.println("  Early termination after " + (i + 1) + " passes.");
                break;
            }
        }
    }
    
    /**
     * Prints the array
     * @param arr Array to print
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=============== OPTIMIZED BUBBLE SORT ===============\n");
        
        // Test case 1 - regular unsorted array
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Test Case 1 (Unsorted array):");
        System.out.print("Original array: ");
        printArray(array1);
        
        int[] arrayToSort = array1.clone();
        optimizedBubbleSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
        
        // Test case 2 - already sorted array (shows optimization)
        System.out.println("\n\nTest Case 2 (Already sorted array - shows optimization):");
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Original array: ");
        printArray(array2);
        
        arrayToSort = array2.clone();
        optimizedBubbleSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
        
        // Test case 3 - nearly sorted array
        System.out.println("\n\nTest Case 3 (Nearly sorted array):");
        int[] array3 = {1, 2, 3, 5, 4, 6, 7};
        System.out.print("Original array: ");
        printArray(array3);
        
        arrayToSort = array3.clone();
        optimizedBubbleSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
    }
}
