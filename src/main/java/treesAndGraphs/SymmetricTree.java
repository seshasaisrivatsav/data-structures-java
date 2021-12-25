package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {
    public static void main(String[] args) {
        /*
                    1
                  2   2
                3  4  4  3
         */
        Node tree = new Node(1);
        tree.leftChild = new Node(2);
        tree.rightChild = new Node(2);
        tree.leftChild.leftChild = new Node(3);
        tree.leftChild.rightChild = new Node(4);
        tree.rightChild.leftChild = new Node(4);
        tree.rightChild.rightChild = new Node (3);

        System.out.println("Is symmetric: " + isSymmetric(tree));
        System.out.println("Is symmetric: " + isSymmetricIterative(tree));
    }

    /*
        A tree is symmetric if the left subtree is a mirror reflection of right sub tree

        Two trees are mirror reflections of each other if
        1. their two roots have same value AND
        2. Right subtree of each tree is mirror reflection of left subtree of another tree
            RightSubtree(Tree) = LeftSubtree(tree)

     */
    public static boolean isSymmetric(Node head) {
        return isMirror(head, head);
    }

    public static boolean isMirror(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) { return true; }
        if (tree1 == null || tree2 == null) {  return false; }
        return (tree1.value == tree2.value && isMirror(tree1.leftChild, tree2.rightChild) && isMirror(tree1.rightChild, tree2.leftChild));
    }


    /**
     * Each two consecutive nodes in the queue should be equal and their subtrees a mirror of each other.
     * Initially the queue contains root and root
     * We do a BFS like algorithm
     * Each time, two nodes are extracted and their values compared, we also check right and left children of the two nodes
     * The right and left children of two nodes are inserted in queue in opposite order
     * If the queue is empty or if we detect the tree is not symmetric we queue
     * @param head {Node}
     * @return  true if a tree is symmetric
     */
    public static boolean isSymmetricIterative(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        queue.add(head);

        while (!queue.isEmpty()) {
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            if (n1 == null && n2== null) { continue; }
            if (n1 == null || n2== null) { return false; }
            if (n1.value != n2.value) { return false; }
            queue.add(n1.leftChild);
            queue.add(n2.rightChild);
            queue.add(n1.rightChild);
            queue.add(n2.leftChild);
        }
        return true;
    }
}
