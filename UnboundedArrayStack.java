/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
public class UnboundedArrayStack {
    private int[] array;
    private int top;
    private static final int INITIAL_CAPACITY = 2;

    public UnboundedArrayStack() {
        array = new int[INITIAL_CAPACITY];
        top = -1;
    }

    // Push with resize if full
    public void push(int x) {
        if (top == array.length - 1) {
            resize(array.length * 2);
        }
        array[++top] = x;
    }

    // Pop with resize if too empty
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int val = array[top--];
        // Shrink if less than 25% full and capacity > initial
        if (top + 1 < array.length / 4 && array.length > INITIAL_CAPACITY) {
            resize(array.length / 2);
        }
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

}
