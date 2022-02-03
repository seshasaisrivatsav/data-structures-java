package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_BreadthFirstSearch_LevelOrderTraversal {
    /**
     * BFS = Breadth First Search
     */
    public static List<Integer> levelOrderSearch(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // Add the first Node to queue
        queue.add(root);

        // While queue is not empty
        while (!queue.isEmpty()) {
            Node currNode = queue.remove(); // remove throws exception if empty, poll returns null
            res.add(currNode.value); // add the curr number to res
            if (currNode.leftChild!=null) { // add left child
                queue.add(currNode.leftChild);
            }
            if (currNode.rightChild!=null) { // add right child
                queue.add(currNode.rightChild);
            }
        }
        return res;
    }
}
