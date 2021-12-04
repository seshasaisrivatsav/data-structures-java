package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a num, design an algorithm to count number of paths that sum to a given value
 */
public class PathsWithSum {
    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.leftChild = new Node(6);
        tree.rightChild = new Node(7);
    }

    /**
     * BRUTE FORCE = Visit all possible paths
     * Time complexity O (n log n)
     * @param node
     * @param targetSum
     * @return int
     */

    public static int countPathsWithSumBruteForce(Node node, int targetSum) {
        if (node == null) { return 0; }

        int pathsFromRoot = countPathsWithSumFromNode(node, 0, targetSum);

        int leftPaths = countPathsWithSumFromNode(node.leftChild, 0, targetSum);
        int rightPaths = countPathsWithSumFromNode(node.rightChild, 0, targetSum);

        return pathsFromRoot + leftPaths + rightPaths;
    }
    public static int countPathsWithSumFromNode(Node node, int currSum, int targetSum) {
        if (node == null) { return 0; }
        currSum = currSum + node.value;

        int totalPaths = 0;
        if (currSum == targetSum) {
            return totalPaths + 1;
        }
        totalPaths = totalPaths + countPathsWithSumFromNode(node.leftChild, currSum, targetSum);
        totalPaths = totalPaths + countPathsWithSumFromNode(node.rightChild, currSum, targetSum);
        return totalPaths;
    }
}
