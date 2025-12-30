/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

import java.util.Stack;

/**
 *
 * @author kulat
 */
public class StackQueueDequeueFriendly {
    private Stack<T> stack1; // For enqueue operations
    private Stack<T> stack2; // For dequeue operations
    
    public StackQueueDequeueFriendly() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Enqueue operation - O(1)
    public void enqueue(T item) {
        // Simply push to stack1
        stack1.push(item);
        System.out.println("Enqueued: " + item);
    }
    
    // Dequeue operation - O(1) amortized (dequeue-friendly)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        // If stack2 is empty, transfer all elements from stack1 to stack2
        // This makes stack2 ready for efficient dequeue
        if (stack2.isEmpty()) {
            transferStacks();
        }
        
        T item = stack2.pop();
        System.out.println("Dequeued: " + item);
        return item;
    }
    
    // Helper method to transfer elements from stack1 to stack2
    private void transferStacks() {
        System.out.println("Transferring " + stack1.size() + " elements from stack1 to stack2...");
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    // Peek at the front element
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        // If stack2 is empty, transfer elements
        if (stack2.isEmpty()) {
            transferStacks();
        }
        
        return stack2.peek();
    }
    
    // Get the front element without removing it
    public T front() {
        return peek();
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // Get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }
    
    // Clear the queue
    public void clear() {
        stack1.clear();
        stack2.clear();
        System.out.println("Queue cleared");
    }
    
    // Display queue elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        
        // First display elements in stack2 (from top to bottom = front of queue)
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        
        // Then display elements in stack1 (as they are = back of queue)
        for (T item : stack1) {
            System.out.print(item + " ");
        }
        
        System.out.println();
    }
    
    // Display internal stack states for debugging
    public void displayStacks() {
        System.out.println("Stack1 (enqueue stack): " + stack1);
        System.out.println("Stack2 (dequeue stack): " + stack2);
        System.out.println("Total size: " + size());
    }
}
