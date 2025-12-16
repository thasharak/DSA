/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author kulat
 */
public class QueueStackPushFriendly {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueStackPushFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    
    public void push(int x) {
        q1.add(x);
    }

    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Move all but last element from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int popped = q1.poll();
        // Swap references
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return popped;
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Move all but last element from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int topVal = q1.peek();
        q2.add(q1.poll());
        // Swap references
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return topVal;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

}
