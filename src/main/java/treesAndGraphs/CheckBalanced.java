package treesAndGraphs;

public class CheckBalanced {

	static class Node {
		int value;
		Node leftChild;
		Node rightChild;
		Node (int val) {
			value = val;
			leftChild = null;
			rightChild = null;
		}
	}

	/**
	 * Approach 1: recurse on the tree
	 * 	Time Complexity: O(N)
	 * 	Space Complexity: O(H) - height of tree
	 * @param root Node
	 * @return boolean true if true is balanced
	 */
	public static boolean isBalanced_fast(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static int checkHeight(Node root) {
		if (root == null) { return -1; } // base case
		int leftHeight = checkHeight(root.leftChild);
		if (leftHeight == Integer.MIN_VALUE) { return Integer.MIN_VALUE; }

		int rightHeight = checkHeight(root.rightChild);
		if (rightHeight == Integer.MIN_VALUE) { return Integer.MIN_VALUE; }

		int heightDiffabs = Math.abs(leftHeight - rightHeight);

		if (heightDiffabs > 1) {
			return Integer.MIN_VALUE;
		} else {
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	/**
	 *
	 * Approach 2: Create a recursive helper that gives max tree height. The caller of it checks for left side right side height diff
	 * 	Time Complexity: O(n log n) = each node is touched once per node above it
	 * 	Space Complexity: O(n)
	 * @param root
	 * @return
	 */
	public static boolean isBalanced_slow(Node root) {
		if (root == null) { return true; }
		int heightDiff = Math.abs(getHeight(root.leftChild) - getHeight(root.rightChild));
		if (heightDiff > 1) {
			return false;
		} else {
			return isBalanced_slow(root.leftChild) && isBalanced_slow(root.rightChild);
		}
	}

	public static int getHeight(Node root) {
		if (root == null) { return -1; } // BASE case, and we will add 1 to begin with
		return Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
	}

	public static void main(String[] args) {
		Node root = new Node(55);
		root.leftChild = new Node(100);
		root.rightChild = new Node(150);
		root.leftChild.leftChild = new Node(200);
		root.leftChild.rightChild = new Node(250);
		root.rightChild.leftChild = new Node(300);
		root.rightChild.rightChild = new Node(350);

		root.rightChild.rightChild.rightChild = new Node(40);
		System.out.println("Expected: true. Actual: " + isBalanced_slow(root));
		System.out.println("Expected: true. Actual: " + isBalanced_fast(root));
		root.rightChild.rightChild.rightChild.rightChild = new Node (45);
		System.out.println("Expected: false. Actual: " + isBalanced_slow(root));
		System.out.println("Expected: false. Actual: " + isBalanced_fast(root));

	}

}
