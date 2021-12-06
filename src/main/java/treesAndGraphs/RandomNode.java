package treesAndGraphs;

import java.util.Random;

/**
 * write a binary tree class with a getRandomNode() method that returns a random node
 *      Probability of picking each node = 1/N
 *  Odds of picking something from left = LEFT_SIZE * 1/N
 *  Odds of picking something from right = RIGHT_SIZE * 1/N
 *
 *  TIME: In a balanced tree, this algorithm will be O(log N), where N is the number of nodes.
 *  So we've to make changes to BinaryTree to have size of nodes on left and right. So with inserts and deletes, we need to update it
 */
public class RandomNode {

    class TreeNode {
        private int val;
        public TreeNode left;
        public TreeNode right;
        private int size = 0; // Modified TreeNode with size
        TreeNode(int val) {
            this.val = val;
            size = 1;
        }
        public int size() { return this.size; }
        public int getVal() { return this.val; }

        public TreeNode getRandomNode() {
            int leftSize = left == null ? 0: left.size();
            Random random = new Random();
            int index = random.nextInt(size);
            if (index < leftSize) {
                return left.getRandomNode();
            } else if (index == leftSize){
                return this;
            } else {
                return right.getRandomNode();
            }
        }

        public void insertInOrder(int data) {
            if(data <= val) {
                if (left == null) {
                    left = new TreeNode(data);
                } else {
                    left.insertInOrder(data);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(data);
                } else {
                    right.insertInOrder(data);
                }
            }
            size++; // V.V.I.P = on each insert increment
        }

        public TreeNode find(int d) {
            if (val == d) {
                return this;
            } else if (d <= val) {
                return left == null ? null : left.find(d);
            } else if (d > val) {
                return right == null ? null: right.find(d);
            }
            return null;
        }
    }

    public void run() {
        TreeNode node = new TreeNode(61);
        node.insertInOrder(52);
        node.insertInOrder(73);
        node.insertInOrder(45);
        node.insertInOrder(54);
        node.insertInOrder(66);
        node.insertInOrder(97);
        for (int i=0; i<7; i++) {
            System.out.println(node.getRandomNode().val);
        }
    }

    public static void main(String[] args) {
        RandomNode randomNode = new RandomNode();
        randomNode.run();
    }
}
