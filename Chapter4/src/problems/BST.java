package problems;

import tree.BSTFromArray;
import tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BST {

    private static void balanced() {
        BinarySearchTree bst = new BinarySearchTree(5);

        bst.addNode(3);
        bst.addNode(2);

        System.out.println("Min height is " + bst.minHeight());
        System.out.println("Max height is " + bst.maxHeight());
        System.out.println("Is balanced? " + bst.isBalanced());
    }

    private static void BSTFromArray() {
        List<Integer> list = IntStream.range(1, 20).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());

        BSTFromArray bstFromArray = new BSTFromArray(list);
        BinarySearchTree bst = bstFromArray.getBST();
        bst.preorder();
    }

    public static void main(String[] args) {BSTFromArray();}
}
