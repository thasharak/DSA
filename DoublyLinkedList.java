
package dsa;

/**
 *
 * @author kulat
 */

    // DoublyLinkedList.java
public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void insertAtPosition(T data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        if (position == size) {
            insertAtEnd(data);
            return;
        }
        
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }
    
    public T deleteFromBeginning() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        T data = head.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }
    
    public T deleteFromEnd() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        T data = tail.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }
    
    public T deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        
        if (position == 0) {
            return deleteFromBeginning();
        }
        
        if (position == size - 1) {
            return deleteFromEnd();
        }
        
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        T data = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return data;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        return size;
    }
    
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        
        Node<T> current = head;
        System.out.print("Doubly Linked List (forward): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        
        Node<T> current = tail;
        System.out.print("Doubly Linked List (backward): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    
    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

