package treesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
 /*
                            1
                          2   3
                        4  5

                        In Order traversal   = (left, root, right) = 4 2 5 1 3
                        Pre order traversal  = (root, left, right) = 1 2 4 5 3
                        Post order traversal = (left, right, root) = 4 5 2 3 1
                        Level order / BFS    = level by level      = 1 2 3 4 5
         */
        Node tree = new Node(1);
        tree.leftChild = new Node(2);
        tree.rightChild = new Node(3);
        tree.leftChild.leftChild = new Node(4);
        tree.leftChild.rightChild = new Node(5);

        System.out.println(Arrays.toString(preOrderTraversalRecursive(tree).toArray())); // Expected  4 5 2 3 1
        System.out.println(Arrays.toString(preOrderIterative(tree).toArray()));

            /*
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
        Node tree2 = new Node(1);
        tree2.leftChild = new Node(2);
        tree2.rightChild = new Node(3);
        tree2.leftChild.leftChild = new Node(4);
        tree2.rightChild.leftChild = new Node(5);
        tree2.rightChild.rightChild = new Node(6);
        tree2.rightChild.leftChild.leftChild = new Node(7);
        tree2.rightChild.leftChild.rightChild = new Node(8);
        System.out.println(Arrays.toString(preOrderTraversalRecursive(tree2).toArray())); //  4 2 7 8 5 6 3 1
        System.out.println(Arrays.toString(preOrderIterative(tree2).toArray()));
    }

    public static List<Integer> preOrderIterative(Node tree) {
        if (tree == null) { return new ArrayList<>(); }
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stack.add(tree); // add root

        while (!stack.isEmpty()) {
            if (tree != null) {
                res.add(tree.value);
                if (tree.rightChild !=null) {
                    stack.push(tree.rightChild);
                }
                tree = tree.leftChild;
            } else {
                tree = stack.pop();
            }
        }
        return res;
    }

    public static List<Integer> preOrderTraversalRecursive(Node tree) {
        List<Integer> res = new ArrayList<>();
        preOrderRecursiveHelper(tree, res);
        return res;
    }

    public static void preOrderRecursiveHelper(Node node, List<Integer> res) {
        if (node != null) {
            res.add(node.value);
            preOrderRecursiveHelper(node.leftChild, res);
            preOrderRecursiveHelper(node.rightChild, res);
        }
    }
}
