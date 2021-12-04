package treesAndGraphs;

import java.util.Stack;

/**
 * From Leetcode 112
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class PathSum {

    public static boolean hasPathRecursion(Node root, int sum) {
        if (root == null) { return false; }
        if (root.leftChild == null && root.rightChild == null && sum - root.value == 0) { return true; }
        return hasPathRecursion(root.leftChild, sum - root.value) || hasPathRecursion(root.rightChild, sum - root.value);
    }
    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) { return false; }
        Stack<Node> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();

        path.push(root);
        sub.push(root.value);

        while (!path.isEmpty()) {
            Node curr = path.pop();
            int currVal = sub.pop();

            if (curr.leftChild == null && curr.rightChild == null) {
                return currVal == sum;
            }

            if (curr.leftChild != null) {
                path.push(curr.leftChild);
                sub.push(curr.leftChild.value + currVal);
            }

            if (curr.rightChild != null) {
                path.push(curr.rightChild);
                sub.push(currVal + curr.rightChild.value);
            }
        }
        return false;
    }
}
