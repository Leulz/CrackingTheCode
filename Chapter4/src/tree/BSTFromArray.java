package tree;

import java.util.Collections;
import java.util.List;

public class BSTFromArray {

    public List<Integer> array;

    public BSTFromArray(List<Integer> array) {
        Collections.sort(array);
        this.array = array;
    }

    public void recur(BinarySearchTree bst, List<Integer> currentArray) {
        if (currentArray.isEmpty())
            return;

        List<Integer> leftPartition = currentArray.subList(0, currentArray.size() / 2);
        List<Integer> rightPartition = currentArray.subList(currentArray.size() / 2 + 1, currentArray.size());

        bst.addNode(currentArray.get(currentArray.size() / 2));

        recur(bst, leftPartition);
        recur(bst, rightPartition);
    }

    public BinarySearchTree getBST() {
        int arraySize = array.size();
        BinarySearchTree bst = new BinarySearchTree();
        recur(bst, array);

        return bst;
    }
}
