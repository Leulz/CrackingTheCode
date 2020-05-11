package problems;

import tree.BSTFromArray;
import tree.BinarySearchTree;
import tree.BinarySearchTreeP;
import tree.nodes.Node;
import tree.nodes.NodeWithParent;

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
        BinarySearchTree bst = Utils.buildBST(20);
        bst.preorder();
    }

    private static void LinkedListPerLevel() {
        BinarySearchTree bst = Utils.buildBST(20);
        List<ll.Node> LLList = bst.getLLPerLevel();
        LLList.forEach(ll.Node::printLL);
    }

    private static void FindNextNode() {
        BinarySearchTreeP bstp = Utils.buildBSTP(20);
        Node n = bstp.findNode(5);
        bstp.preorder();
        System.out.println("Next node is " + bstp.findNextNode((NodeWithParent) n).getData());
    }

    public static void main(String[] args) {FindNextNode();}
}
