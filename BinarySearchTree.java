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

public class BinarySearchTree {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    
    private TreeNode root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    // Insert a value into BST
    public void insert(int val) {
        root = insertRec(root, val);
    }
    
    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }
        
        return root;
    }
    
    // Search for a value in BST
    public boolean search(int val) {
        return searchRec(root, val);
    }
    
    private boolean searchRec(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        
        if (val < root.val) {
            return searchRec(root.left, val);
        } else {
            return searchRec(root.right, val);
        }
    }
    
    // Delete a value from BST
    public void delete(int val) {
        root = deleteRec(root, val);
    }
    
    private TreeNode deleteRec(TreeNode root, int val) {
        if (root == null) return null;
        
        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            
            // Node with two children: Get inorder successor
            root.val = minValue(root.right);
            
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.val);
        }
        
        return root;
    }
    
    private int minValue(TreeNode root) {
        int minVal = root.val;
        while (root.left != null) {
            minVal = root.left.val;
            root = root.left;
        }
        return minVal;
    }
    
    // Inorder traversal (sorted order)
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }
    
    private void inorderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.val);
            inorderRec(root.right, result);
        }
    }
    
    // Preorder traversal
    public List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        preorderRec(root, result);
        return result;
    }
    
    private void preorderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderRec(root.left, result);
            preorderRec(root.right, result);
        }
    }
    
    // Postorder traversal
    public List<Integer> postorder() {
        List<Integer> result = new ArrayList<>();
        postorderRec(root, result);
        return result;
    }
    
    private void postorderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderRec(root.left, result);
            postorderRec(root.right, result);
            result.add(root.val);
        }
    }
    
    // Find minimum value
    public int findMin() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }
    
    // Find maximum value
    public int findMax() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert values
        int[] values = {50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45};
        System.out.println("Inserting values: " + Arrays.toString(values));
        
        for (int val : values) {
            bst.insert(val);
        }
        
        System.out.println("\nInorder traversal (sorted): " + bst.inorder());
        System.out.println("Preorder traversal: " + bst.preorder());
        System.out.println("Postorder traversal: " + bst.postorder());
        
        System.out.println("\nSearch operations:");
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));
        
        System.out.println("\nMinimum value: " + bst.findMin());
        System.out.println("Maximum value: " + bst.findMax());
        
        // Delete operations
        System.out.println("\nDeleting 20:");
        bst.delete(20);
        System.out.println("Inorder after deletion: " + bst.inorder());
        
        System.out.println("\nDeleting 30:");
        bst.delete(30);
        System.out.println("Inorder after deletion: " + bst.inorder());
        
        System.out.println("\nDeleting 50 (root):");
        bst.delete(50);
        System.out.println("Inorder after deletion: " + bst.inorder());
    }
}
