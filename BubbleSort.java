/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
public class BubbleSort {
    
    /**
     * Standard Bubble Sort algorithm
     * @param arr Array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("\nStarting Bubble Sort...");
        System.out.println("Array length: " + n);
        System.out.println("----------------------");
        
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nPass " + (i + 1) + ":");
            System.out.print("  Before: ");
            printArray(arr);
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println("  Swapped: " + arr[j] + " and " + arr[j + 1]);
                }
            }
            
            System.out.print("  After:  ");
            printArray(arr);
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
        System.out.println("=============== BUBBLE SORT ===============\n");
        
        // Test case 1
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Test Case 1:");
        System.out.print("Original array: ");
        printArray(array1);
        
        // Make a copy to preserve original
        int[] arrayToSort = array1.clone();
        bubbleSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
        
        // Test case 2 - smaller array
        System.out.println("\n\nTest Case 2 (Smaller array):");
        int[] array2 = {5, 1, 4, 2, 8};
        System.out.print("Original array: ");
        printArray(array2);
        
        arrayToSort = array2.clone();
        bubbleSort(arrayToSort);
        
        System.out.println("\n==========================================");
        System.out.print("Final sorted array: ");
        printArray(arrayToSort);
        System.out.println("==========================================");
        
        // Test case 3 - already sorted
        System.out.println("\n\nTest Case 3 (Already sorted):");
        int[] array3 = {1, 2, 3, 4, 5};
        System.out.print("Original array: ");
        printArray(array3);
        
        arrayToSort = array3.clone();
        bubbleSort(arrayToSort);
    }
}
