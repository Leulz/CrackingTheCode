package problems;

import tree.BSTFromArray;
import tree.BinarySearchTree;
import tree.BinarySearchTreeP;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static BinarySearchTree buildBST(int range) {
        List<Integer> list = IntStream.range(1, range).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());

        BSTFromArray bstFromArray = new BSTFromArray(list);
        return bstFromArray.getBST();
    }

    public static BinarySearchTreeP buildBSTP(int range) {
        List<Integer> list = IntStream.range(1, range).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());

        BSTFromArray bstFromArray = new BSTFromArray(list);
        return bstFromArray.getBSTP();
    }
}
