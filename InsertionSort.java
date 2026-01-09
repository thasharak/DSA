/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
public class InsertionSort {
    
    /**
     * Insertion Sort algorithm with step-by-step visualization
     * @param arr Array to be sorted
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("\nStarting Insertion Sort...");
        System.out.println("Array length: " + n);
        System.out.println("--------------------------");
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            System.out.println("\nPass " + i + ":");
            System.out.print("  Key element: " + key + " (at position " + i + ")");
            System.out.print("\n  Sorted portion: ");
            printSubArray(arr, 0, i);
            
            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                System.out.println("  Move " + arr[j] + " from position " + j + " to position " + (j + 1));
                j = j - 1;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
            System.out.println("  Insert " + key + " at position " + (j + 1));
            System.out.print("  Current array: ");
            printArray(arr);
        }
    }
    
    /**
     * Prints the entire array
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
    
    /**
     * Prints a subarray
     * @param arr Array
     * @param start Start index (inclusive)
     * @param end End index (exclusive)
     */
    public static void printSubArray(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i]);
            if (i < end - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=============== INSERTION SORT ===============\n");
        
        // Test case 1
        int[] array1 = {12, 11, 13, 5, 6};
        System.out.println("Test Case 1:");
        System.out.print("Original array: ");
        printArray(array1);
        
        int[] arrayToSort = array1.clone();
        insertionSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
        
        // Test case 2
        System.out.println("\n\nTest Case 2:");
        int[] array2 = {9, 5, 1, 4, 3};
        System.out.print("Original array: ");
        printArray(array2);
        
        arrayToSort = array2.clone();
        insertionSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
        
        // Test case 3 - already sorted
        System.out.println("\n\nTest Case 3 (Already sorted - best case):");
        int[] array3 = {1, 2, 3, 4, 5};
        System.out.print("Original array: ");
        printArray(array3);
        
        arrayToSort = array3.clone();
        insertionSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
        
        // Demonstrate time complexity difference
        System.out.println("\n\nTime Complexity Analysis:");
        System.out.println("-------------------------");
        System.out.println("Best case (already sorted): O(n)");
        System.out.println("Worst case (reverse sorted): O(n²)");
        System.out.println("Average case: O(n²)");
        System.out.println("Space complexity: O(1) - In-place sorting");
    }
}
