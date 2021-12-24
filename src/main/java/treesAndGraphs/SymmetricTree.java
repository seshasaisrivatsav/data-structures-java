package treesAndGraphs;

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
    }

    public static boolean isSymmetric(Node head) {
        return  false;
    }
}
