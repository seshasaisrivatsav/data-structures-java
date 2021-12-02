package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Implement Binary Tree and methods in it
 *  Image of a balanced binary tree https://www.baeldung.com/wp-content/uploads/2017/12/Tree-1.jpg
 *  Methods
 *      - Insert
 *      - Find an element
 *      - Delete an element
 *      - Traversal
 *          - DFS (in order, pre order, post order)
 *          - BFS
 *
 */
public class BinaryTree {

    class Node {
        int value;
        Node leftChild;
        Node rightChild;
        Node(int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }
    }

    Node root;


    ////////////////////////////////////////////////////////////////////////////////
    // Public Methods
    //  - add(int) => adds given in to binary tree
    //  - containsNode(int) => returns true if the given value is present in tree
    //  - delete(int) => deletes a node with given value
    //  - findNodeIterative() => Finds Node by given value
    ////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param value adds the given value to the Balanced Binary Tree
     * @link addRecursive
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public void delete(int value) {
        root = deleteNodeRecursive(root, value);
    }

    public Node findNodeIterative(int key) {
        Node focusNode = root;

        while (focusNode.value != key) {
            if (key < focusNode.value) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return null;
            }
        }

        return focusNode;
    }
    ////////////////////////////////////////////////////////////////////////////////
    // Private Methods
    // - addRecursive (recursively adds given node to tree)
    // - containsNodeRecursive - Base case return false if null or if value found return true.
    // - deleteNodeRecursive
    ////////////////////////////////////////////////////////////////////////////////

    private Node addRecursive(Node curr, int value) {
        if (curr == null) {
            return new Node(value);
        }

        if (value < curr.value) {
            curr.leftChild = addRecursive(curr.leftChild, value);
        } else if (value > curr.value) {
            curr.rightChild = addRecursive(curr.rightChild, value);
        } else {
            return curr; // the value already exists
        }

        return curr;
    }

    private boolean containsNodeRecursive(Node curr, int value) {
        if (curr == null) {
            return false;
        }
        if (curr.value == value) {
            return true;
        }
        return (value < curr.value) ?
                containsNodeRecursive(curr.leftChild, value) :
                containsNodeRecursive(curr.rightChild, value);
    }

    private Node deleteNodeRecursive(Node curr, int value) {
        if (curr == null) {
            return null;
        }
        if (curr.value == value) { // Here we delete, and we have 3 cases
            // CASE 1:  Node has no children - Just replace this node with null in its parent
            if (curr.leftChild == null && curr.rightChild == null) {
                return null;
            }

            // CASE 2: Node has 1 child - replace this node with child
            if (curr.leftChild == null) {
                return curr.rightChild;
            }
            if (curr.rightChild == null) {
                return curr.leftChild;
            }

            // CASE 3:  Node has 2 children - reorganize tree -
            // In this case we want to find the smallest child node to replace
            int smallestValue = findSmallestValue(curr.rightChild);
            curr.value = smallestValue;
            curr.rightChild = deleteNodeRecursive(curr.rightChild, smallestValue);
            return curr;
        }
        if (value < curr.value) {
            curr.leftChild = deleteNodeRecursive(curr.leftChild, value);
            return curr;
        }
        curr.rightChild = deleteNodeRecursive(curr.rightChild, value);
        return curr;
    }


    private int findSmallestValue(Node curr) {
        return curr.leftChild == null ? curr.value : findSmallestValue(curr.leftChild);
    }


    /**
     * DFS - Depth First Search
     *  1. in order traversal (left, root, right)
     *  2. pre order traversal (root, left, right)
     *  3. post order traversal (left, right, root)
     * @param curr Node
     */
    public void inOrderTraversal(Node curr) {
        if (curr != null) {
            inOrderTraversal(curr.leftChild); // LEFT
            System.out.println(curr.value); // NODE
            inOrderTraversal(curr.rightChild); // RIGHT
        }
    }

    public void preOrderTraversal(Node curr) {
        if (curr != null) {
            System.out.println(curr.value); // NODE
            preOrderTraversal(curr.leftChild); // LEFT
            preOrderTraversal(curr.rightChild); // RIGHT
        }
    }

    public void postOrderTraversal(Node curr) {
        if (curr != null) {
            postOrderTraversal(curr.leftChild); // LEFT
            postOrderTraversal(curr.rightChild); // RIGHT
            System.out.println(curr.value); // NODE
        }
    }

    /**
     * BFS = Breadth First Search
     */
    public void levelOrderSearch() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            System.out.println(currNode.value);

            if (currNode.leftChild!=null) {
                queue.add(currNode.leftChild);
            }
            if (currNode.rightChild!=null) {
                queue.add(currNode.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        theTree.add(50);
        theTree.add(25);
        theTree.add(15);
        theTree.add(30);
        theTree.add(75);
        theTree.add(85);


        System.out.println("Expected: true. Actual: " + theTree.containsNode(50));
        System.out.println("Expected: false. Actual: " + theTree.containsNode(51));
        theTree.postOrderTraversal(theTree.root);

        System.out.println("Search for 30");

        BinaryTree newTree = new BinaryTree();
        newTree.add(60);
        newTree.add(40);
        newTree.add(80);
        newTree.add(30);
        newTree.add(50);
        newTree.add(70);
        newTree.add(90);

        newTree.delete(40);
        printTree(newTree);
    }

    private static void printTree(BinaryTree newTree) {
        // Base Case
        if(newTree.root == null)
            return;

        // Create an empty queue for level order traversal
        Queue<Node> q =new LinkedList<Node>();

        // Enqueue Root and initialize height
        q.add(newTree.root);


        while(true)
        {

            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0)
            {
                Node node = q.peek();
                System.out.print(node.value + " ");
                q.remove();
                if(node.leftChild != null)
                    q.add(node.leftChild);
                if(node.rightChild != null)
                    q.add(node.rightChild);
                nodeCount--;
            }
            System.out.println();
        }
    }


}
