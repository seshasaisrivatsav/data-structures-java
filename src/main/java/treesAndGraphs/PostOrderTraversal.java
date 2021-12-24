package treesAndGraphs;

import java.util.*;

public class PostOrderTraversal {
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

        System.out.println(Arrays.toString(getPostOrderList_recursive(tree).toArray())); // Expected  4 5 2 3 1
        System.out.println(Arrays.toString(postOrderTraversal_iterative(tree).toArray()));

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
        System.out.println(Arrays.toString(getPostOrderList_recursive(tree2).toArray())); //  4 2 7 8 5 6 3 1
        System.out.println(Arrays.toString(postOrderTraversal_iterative(tree2).toArray()));
    }

    /**
     * Pre Order = Root, Left, Right
     * Post Order = Left, Right, Root
     * In Order = Left, Root, Right
     *
     * @param tree
     * @return
     */
    public static List<Integer> getPostOrderList_recursive(Node tree) {
        List<Integer> res = new ArrayList<>();
        postOrderHelper(tree, res);
        return res;
    }

    public static void postOrderHelper(Node head, List<Integer> res) {
        if (head != null) {
            postOrderHelper(head.leftChild, res);
            postOrderHelper(head.rightChild, res);
            res.add(head.value);
        }
    }

    public static List<Integer> postOrderTraversal_iterative(Node root) {
        if (root==null) { return new ArrayList<>(); }
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            if (root!=null) {
                stack.push(root);
                res.addFirst(root.value);
                root = root.rightChild;
            } else {
                Node curr = stack.pop();
                root = curr.leftChild;
            }
        }
        return res;
    }
}
