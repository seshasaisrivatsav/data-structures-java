package treesAndGraphs;

/**
 * Check if a given Tree is a Binary Search Tree
 * BST = left node < parent < right
 */
public class CheckIfGivenTreeIsBST {
	public static void main(String[] args) {
		/*
		 		  7
		 		5	 10
		 	3   6   8   11
		 */
		Node root = new Node(7);
		root.leftChild = new Node(5);
		root.rightChild = new Node(10);
		root.leftChild.leftChild = new Node(3);
		root.leftChild.rightChild = new Node(6);
		root.rightChild.leftChild = new Node(8);
		root.rightChild.rightChild = new Node(11);
		System.out.println("balanced: true. Actual:" + check(root));
		root.rightChild.rightChild.rightChild = new Node(12);
		System.out.println("balanced: true. Actual:" + check(root));
		root.rightChild.rightChild.rightChild.rightChild = new Node(4);
		System.out.println("balanced: false. Actual:" + check(root));

	}

	/**
	 * It is easy to think that we can check if every node's value is greater than left node and less than right
	 * But this approach won't work
	 *
	 * We need to pass upper limit as node value when checking left
	 * We need to lass lower limit as node value when traveling right
	 *
	 * Steps:
	 * 	0. We start with root, lower bound = Integer.MIN_VALUE, upper bound = Integer.MAX_VALUE
	 *  1. Upper bound on left is root's value
	 *  2. Lower bound on right is root's value
	 *
	 * @param root
	 * @return
	 */
	public static boolean check(Node root) {
		  return checkBSTUtil(root, null, null);
		
	}
	
	public static boolean checkBSTUtil(Node root, Integer min, Integer max) {
		if (root==null) return true;

		if ((min!=null && root.value <= min) || (max!=null && root.value >= max)) { return false; }

		boolean leftBst = checkBSTUtil(root.leftChild, min, root.value);
		boolean rightBst = checkBSTUtil(root.rightChild, root.value, max);

		return leftBst && rightBst;
	}

}
