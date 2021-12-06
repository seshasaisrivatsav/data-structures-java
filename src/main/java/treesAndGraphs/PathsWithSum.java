package treesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a num, design an algorithm to count number of paths that sum to a given value
 */
public class PathsWithSum {
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.leftChild = new Node(5);
        tree.leftChild.leftChild = new Node(3);
        tree.leftChild.rightChild = new Node(2);
        tree.leftChild.leftChild.leftChild = new Node(3);
        tree.leftChild.rightChild.leftChild = new Node(-2);
        tree.leftChild.rightChild.rightChild = new Node(1);
        tree.rightChild = new Node(-3);
        tree.rightChild.rightChild = new Node(11);

        System.out.println(countPathsWithSumOptimal(tree, 8));
        System.out.println(countPathsWithSumBruteForce(tree, 8));
    }


    /**
     * Using additional Storage like a hashmap will help time complexity
     * We use hash map to store running sum of path and count
     *
     * Time Complexity: O(n)
     */

    public static int countPathsWithSumOptimal(Node node, int targetSum) {
        return countPathsWithSumHelper(node, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private static int countPathsWithSumHelper(Node node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) { return 0; }

        // Count paths with sum ending at current node
        runningSum = runningSum + node.value;

        int totalPaths = pathCount.getOrDefault(runningSum - targetSum, 0); // if given value isn't present returns default

        // If runningSum = targetSum, then 1 additional path starts at root, add it
        if (runningSum == targetSum) {
            totalPaths = totalPaths+1;
        }
        // increment path count, recurse and decrement path
        incrementHashTable(pathCount, runningSum, 1);
        totalPaths = totalPaths + countPathsWithSumHelper(node.leftChild, targetSum, runningSum, pathCount);
        totalPaths = totalPaths + countPathsWithSumHelper(node.rightChild, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    public static void incrementHashTable(HashMap<Integer, Integer> hashMap, int key, int val) {
        int newCount = hashMap.getOrDefault(key, 0)+val;
        if (newCount==0) { // remove when zero to reduce space usage
            hashMap.remove(key);
        } else {
            hashMap.put(key, newCount);
        }
    }



    /////////           BRUTE FORCE         ///////////////////////////

    /**
     * BRUTE FORCE = Visit all possible paths
     * Time complexity O (n2)
     * @param node
     * @param targetSum
     * @return int
     */

    public static int countPathsWithSumBruteForce(Node node, int targetSum) {
        if (node == null) { return 0; }

        int pathsFromRoot = countPathsWithSumFromNode(node, 0, targetSum);
        int leftPaths     = countPathsWithSumFromNode(node.leftChild, 0, targetSum);
        int rightPaths    = countPathsWithSumFromNode(node.rightChild, 0, targetSum);

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
