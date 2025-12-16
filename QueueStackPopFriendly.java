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
public class QueueStackPopFriendly {
     private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueStackPopFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    
    public void push(int x) {
        q2.add(x);
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.poll();
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

}
