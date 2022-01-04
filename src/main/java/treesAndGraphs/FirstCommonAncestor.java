package treesAndGraphs;

public class FirstCommonAncestor {
	static class Node {
		Node left;
		Node right;
		int value;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(11);
		root.left.right.left = new Node(9);
		root.left.right.right = new Node(5);

		root.right = new Node(8);
		root.right.right = new Node(13);
		root.right.right.left = new Node(7);

		/*
				   3
			  6     	8
			2    11        13
			   9   5	  7

			LCA(5, 2) = 6
		 */

		System.out.println(lca(root, root.left.right.right, root.left.left ).value);
	}

	/**
	 * Excellently Explained: https://youtu.be/13m9ZCB8gjw?t=267
	 * @param root Node
	 * @param N1 Node
	 * @param N2 Node
	 * @return
	 */
	public static Node lca(Node root, Node N1, Node N2) {
		// If dead end, return null
		if (root == null)
			return null;

		// if you find one of the element, return that
		if (root == N1 || root == N2)
			return root;

		// calculate the same for left and right
		Node left = lca(root.left, N1, N2);
		Node right = lca(root.right, N1, N2);

		// getting not null from left and right means, that element is the lca
		if (left != null && right != null)
			return root;

		// if both left and right are null, return null
		if (left == null && right == null)
			return null;

		// if left isn't null return left
		return left != null ? left : right;

	}
}