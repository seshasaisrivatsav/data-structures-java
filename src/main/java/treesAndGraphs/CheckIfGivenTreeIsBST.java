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
