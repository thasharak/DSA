/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author kulat
 */
import java.util.*;

public class AVLTree {
    
    static class AVLNode {
        int val;
        int height;
        AVLNode left;
        AVLNode right;
        
        AVLNode(int val) {
            this.val = val;
            this.height = 1;
            left = null;
            right = null;
        }
    }
    
    private AVLNode root;
    
    public AVLTree() {
        root = null;
    }
    
    // Get height of node
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }
    
    // Get balance factor
    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    
    // Right rotate
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        
        // Perform rotation
        x.right = y;
        y.left = T2;
        
        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    // Left rotate
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        
        // Perform rotation
        y.left = x;
        x.right = T2;
        
        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    // Insert a value into AVL tree
    public void insert(int val) {
        root = insertRec(root, val);
    }
    
    private AVLNode insertRec(AVLNode node, int val) {
        // Standard BST insert
        if (node == null) return new AVLNode(val);
        
        if (val < node.val) {
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        } else {
            return node; // Duplicate values not allowed
        }
        
        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        // Get balance factor
        int balance = getBalance(node);
        
        // Left Left Case
        if (balance > 1 && val < node.left.val) {
            return rightRotate(node);
        }
        
        // Right Right Case
        if (balance < -1 && val > node.right.val) {
            return leftRotate(node);
        }
        
        // Left Right Case
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right Left Case
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    // Delete a value from AVL tree
    public void delete(int val) {
        root = deleteRec(root, val);
    }
    
    private AVLNode deleteRec(AVLNode root, int val) {
        if (root == null) return null;
        
        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        } else {
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                AVLNode temp = (root.left != null) ? root.left : root.right;
                
                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    // One child case
                    root = temp;
                }
            } else {
                // Node with two children
                AVLNode temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = deleteRec(root.right, temp.val);
            }
        }
        
        if (root == null) return null;
        
        // Update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        
        // Get balance factor
        int balance = getBalance(root);
        
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        return root;
    }
    
    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    // Search for a value
    public boolean search(int val) {
        return searchRec(root, val);
    }
    
    private boolean searchRec(AVLNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        
        if (val < root.val) {
            return searchRec(root.left, val);
        } else {
            return searchRec(root.right, val);
        }
    }
    
    // Inorder traversal
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }
    
    private void inorderRec(AVLNode root, List<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.val);
            inorderRec(root.right, result);
        }
    }
    
    // Level order traversal (to show tree structure)
    public List<List<Integer>> levelOrder() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<AVLNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                AVLNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }
    
    // Get tree height
    public int getTreeHeight() {
        return height(root);
    }
    
    // Check if tree is balanced
    public boolean isBalanced() {
        return isBalancedRec(root);
    }
    
    private boolean isBalancedRec(AVLNode node) {
        if (node == null) return true;
        
        int balance = getBalance(node);
        if (Math.abs(balance) > 1) return false;
        
        return isBalancedRec(node.left) && isBalancedRec(node.right);
    }
    
    // Main method for testing
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        
        System.out.println("Testing AVL Tree Self-Balancing Property\n");
        
        // Test case that would create an unbalanced BST
        int[] testValues = {10, 20, 30, 40, 50, 25};
        
        System.out.println("Inserting values: " + Arrays.toString(testValues));
        
        for (int val : testValues) {
            avl.insert(val);
            System.out.println("\nAfter inserting " + val + ":");
            System.out.println("Level Order: " + avl.levelOrder());
            System.out.println("Tree Height: " + avl.getTreeHeight());
            System.out.println("Is Balanced: " + avl.isBalanced());
        }
        
        System.out.println("\nFinal AVL Tree:");
        System.out.println("Inorder Traversal (sorted): " + avl.inorder());
        System.out.println("Level Order Traversal: " + avl.levelOrder());
        System.out.println("Tree Height: " + avl.getTreeHeight());
        System.out.println("Is Balanced: " + avl.isBalanced());
        
        // Search operations
        System.out.println("\nSearch operations:");
        System.out.println("Search 30: " + avl.search(30));
        System.out.println("Search 100: " + avl.search(100));
        
        // Delete operations
        System.out.println("\nDeleting 40:");
        avl.delete(40);
        System.out.println("Inorder after deletion: " + avl.inorder());
        System.out.println("Level Order after deletion: " + avl.levelOrder());
        System.out.println("Is Balanced: " + avl.isBalanced());
        
        System.out.println("\nDeleting 20:");
        avl.delete(20);
        System.out.println("Inorder after deletion: " + avl.inorder());
        System.out.println("Level Order after deletion: " + avl.levelOrder());
        System.out.println("Is Balanced: " + avl.isBalanced());
        
        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        
        // Create unbalanced BST for comparison
        BinarySearchTree unbalancedBST = new BinarySearchTree();
        for (int val : testValues) {
            unbalancedBST.insert(val);
        }
        
        System.out.println("AVL Tree Height: " + avl.getTreeHeight());
        System.out.println("BST Search 25: " + avl.search(25));
    }
}
