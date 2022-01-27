package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Companies: LinkedIn, Amazon, Facebook
 */
public class TwoSumInBST {
    public static void main(String[] args) {
        /*
                5
              3    6
             2  4     7

             k=9   | nodes exists (2+7)
         */
        Node tree = new Node(5);
        tree.leftChild = new Node(3);
        tree.rightChild = new Node(6);
        tree.leftChild.leftChild = new Node(2);
        tree.leftChild.rightChild = new Node(4);
        tree.rightChild.rightChild = new Node (7);

        System.out.println("Expected: true. Actual: " + findTarget(tree, 7));
        System.out.println("Expected: false. Actual: " + findTarget(tree, 28));
    }

    /**
     * Approach:
     *      - Since this is a Binary Search Tree, In order traversal yields sorted
     *      - Put the results in a list
     *      - Once we've the list, we can use 2 pointer approach to find
     * @param tree Node tree node
     * @param k int target
     * @return boolean - true if found
     */
    public static boolean findTarget(Node tree, int k) {
        List<Integer> nodes = new ArrayList<>();
        inOrderTraversal(tree, nodes);
        int start = 0;
        int end = nodes.size()-1;
        // V.V.I. P = don't do start <=end, start < end
        while (start < end) {
            int currSum = nodes.get(start) + nodes.get(end);
            if (currSum==k) {
                return true;
            } else if (currSum < k) {
                start ++;
            } else {
                end --;
            }
        }
        return false;
    }

    /**
     * In order traversal in BST
     * @param root Node
     * @param visited List<Integer> visited
     */
    public static void inOrderTraversal(Node root, List<Integer> visited) {
        if (root!=null) {
            inOrderTraversal(root.leftChild, visited);
            visited.add(root.value);
            inOrderTraversal(root.rightChild, visited);
        }
    }
}
