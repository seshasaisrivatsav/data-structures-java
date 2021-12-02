package treesAndGraphs;

import java.util.*;

/**
 * given a binary tree, write algorithm that gives linked list of nodes at each depth
 *
 * Approach 1: modified DFS using pre order traversal by passing level
 * Approach 2: modified BFS
 *
 *
 */
public class ListOfDepths {
    static class Node {
        int value;
        Node leftChild;
        Node rightChild;
        Node(int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }
    }
    /**
     * Approach 1: Use modified DFS pre order traversal (visits head, left, right) and pass level+1 to each call
     *      Time Complexity: O(N)
     *      space complexity: O(log N) + O(N)   (We make O(log N) recursive calls (in case of balanced tree))
     * Array List: Dynamic Array. Slow manipulation as uses array. Acts as a list only. Good for data storing and accessing.
     * Linked List: Doubly linked list. Fast insertion. Acts as list and queue. Good for data manipulation
     *
     *    3  4
     *    |  |
     * 1  2  3  4
     * __ __ __ __
     * @param node Node
     * @return List<List<Integer>> representing list of levels in the tree
     */

    public static List<List<Integer>> listOfDepth_recursive(Node node) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       if (node == null) { return res; }
       listOfDepth_helper(res, node, 0);
       return res;
    }

    public static void listOfDepth_helper(List<List<Integer>> res, Node curr, int level) {
        if (curr == null) { return; }
        List<Integer> currentLevelList;
        if (res.size() <= level) { // The result can be max size of level
            // Levels are traversed in order/
            // So if this is the first time we're visiting level i, we've seen 0 to i-1 already and we can add the level at the end
            currentLevelList = new ArrayList<>();
            currentLevelList.add(curr.value);
            res.add(currentLevelList);
        } else {
            res.get(level).add(curr.value);
        }
        listOfDepth_helper(res, curr.leftChild, level+1);
        listOfDepth_helper(res, curr.rightChild, level+1);
    }

    /**
     * Approach 2: Using modified BFS
     *      Time Complexity: O(N)
     *      Space Complexity: O(N)
     *  We modify BFS such that we keep a queue
     *      but in each iteration, we peek each element, and iterate the current queue size number of times to add to a level list
     *      for each iteration we add the list to our result
     * @param node
     * @return
     */
    public static List<List<Integer>> listOfDepth_iterative(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if (node == null) { return res; }


        queue.add(node);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new LinkedList<Integer>();

            for(int i=0; i<levelSize; i++) {
                Node queuePeek = queue.peek();
                if (queuePeek.leftChild != null) {
                    queue.add(queuePeek.leftChild);
                }
                if (queuePeek.rightChild != null) {
                    queue.add(queuePeek.rightChild);
                }
                levelList.add(queue.poll().value);
            }

            res.add(levelList);
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.leftChild = new Node(9);
        root.rightChild = new Node(20);
        root.rightChild.leftChild = new Node(17);
        root.rightChild.rightChild = new Node(18);

        System.out.println("Expected: [[3], [9, 20], [17, 18]]");
        System.out.println("Actual Recursive: " + listOfDepth_recursive(root));

        System.out.println("Actual Iterative: " + listOfDepth_iterative(root));
    }
}
