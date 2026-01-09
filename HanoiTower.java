/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
public class HanoiTower {
    
    /**
     * Solves the Tower of Hanoi puzzle for n disks
     * @param n Number of disks
     * @param source Source rod
     * @param auxiliary Auxiliary rod
     * @param target Target rod
     */
    public static void solveHanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        
        // Move n-1 disks from source to auxiliary using target as buffer
        solveHanoi(n - 1, source, target, auxiliary);
        
        // Move the nth disk from source to target
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        
        // Move n-1 disks from auxiliary to target using source as buffer
        solveHanoi(n - 1, auxiliary, source, target);
    }
    
    /**
     * Solves Tower of Hanoi and returns the minimum number of moves required
     * @param n Number of disks
     * @param source Source rod
     * @param auxiliary Auxiliary rod
     * @param target Target rod
     * @return Minimum number of moves required
     */
    public static int solveHanoiWithCount(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return 1;
        }
        
        int moves = 0;
        
        // Move n-1 disks from source to auxiliary using target as buffer
        moves += solveHanoiWithCount(n - 1, source, target, auxiliary);
        
        // Move the nth disk from source to target
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        moves++;
        
        // Move n-1 disks from auxiliary to target using source as buffer
        moves += solveHanoiWithCount(n - 1, auxiliary, source, target);
        
        return moves;
    }
    
    /**
     * Calculates the minimum number of moves required without printing steps
     * @param n Number of disks
     * @return Minimum number of moves
     */
    public static int calculateMinMoves(int n) {
        // Minimum moves = 2^n - 1
        return (int) Math.pow(2, n) - 1;
    }
    
    public static void main(String[] args) {
        System.out.println("=============== TOWER OF HANOI ===============\n");
        
        int numberOfDisks = 3;
        char source = 'A';
        char auxiliary = 'B';
        char target = 'C';
        
        System.out.println("Number of disks: " + numberOfDisks);
        System.out.println("Source: " + source + ", Auxiliary: " + auxiliary + ", Target: " + target);
        System.out.println("\nSolution Steps:");
        System.out.println("----------------");
        
        // Solve Tower of Hanoi
        int totalMoves = solveHanoiWithCount(numberOfDisks, source, auxiliary, target);
        
        System.out.println("\n==========================================");
        System.out.println("Total moves made: " + totalMoves);
        System.out.println("Minimum moves required (2^n - 1): " + calculateMinMoves(numberOfDisks));
        System.out.println("==========================================");
        
        // Test with different number of disks
        System.out.println("\n\nTesting with 4 disks:");
        System.out.println("=====================");
        System.out.println("Minimum moves for 4 disks: " + calculateMinMoves(4));
        System.out.println("\nFirst few moves for 4 disks:");
        solveHanoi(4, 'A', 'B', 'C');
    }
}
