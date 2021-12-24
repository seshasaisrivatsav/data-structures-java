package treesAndGraphs;

import java.util.*;

public class InOrderTraversal {
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

         System.out.println(Arrays.toString(inorderTraversal_iterative(tree).toArray())); // Expected 4 2 5 1 3
         System.out.println(Arrays.toString(inOrderTraversalRecursive(tree).toArray())); // Expected 4 2 5 1 3

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
        System.out.println(Arrays.toString(inorderTraversal_iterative(tree2).toArray()));
        System.out.println(Arrays.toString(inOrderTraversalRecursive(tree2).toArray()));
    }

    // https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    public static List<Integer> inorderTraversal_iterative(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root !=null) {
            if (root!=null) {
                stack.push(root);
                root = root.leftChild;
            } else {
                root = stack.pop();
                res.add(root.value);
                root = root.rightChild;
            }
        }
        return res;
    }


    public static List<Integer> inOrderTraversalRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversalRecursiveHelper(root, res);
        return res;
    }

    public static void inOrderTraversalRecursiveHelper(Node root, List<Integer> res) {
        if (root != null) {
            inOrderTraversalRecursiveHelper(root.leftChild, res);
            res.add(root.value);
            inOrderTraversalRecursiveHelper(root.rightChild, res);
        }
    }
}
