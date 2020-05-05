package problems;

import tree.BinarySearchTree;

public class BST {

    private static void balanced() {
        BinarySearchTree bst = new BinarySearchTree(5);

        bst.addNode(3);
        bst.addNode(2);

        System.out.println("Min height is " + bst.minHeight());
        System.out.println("Max height is " + bst.maxHeight());
        System.out.println("Is balanced? " + bst.isBalanced());
    }

    public static void main(String[] args) {
        balanced();
    }
}
