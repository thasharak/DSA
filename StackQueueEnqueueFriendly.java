
package dsa;

import java.util.Stack;

/**
 *
 * @author kulat
 */
public class StackQueueEnqueueFriendly {
    


    private final Stack<Integer> stack1; 
    private Stack<Integer> stack2; 

    public StackQueueEnqueueFriendly() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue friendly: O(1)
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue may be O(n) if stack2 is empty
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

