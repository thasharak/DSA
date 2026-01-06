/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
public class RabbitProblem {

    static int rabbitCount(int n) {
        if (n <= 1)
            return n;
        return rabbitCount(n - 1) + rabbitCount(n - 2);
    }

    public static void main(String[] args) {
        int months = 6;
        System.out.println("Rabbit pairs after " + months + " months: " + rabbitCount(months));

    }
    
}
