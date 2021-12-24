package treesAndGraphs;

import java.util.*;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		/*
				5
			10   15
		  20  25  30  35
						40
						  45
		 */
		Node root = new Node(5);
		root.leftChild = new Node(10);
		root.rightChild = new Node(15);
		root.leftChild.leftChild = new Node(20);
		root.leftChild.rightChild = new Node(25);
		root.rightChild.leftChild = new Node(30);
		root.rightChild.rightChild = new Node(35);

		root.rightChild.rightChild.rightChild = new Node(40);
		root.rightChild.rightChild.rightChild.rightChild = new Node(45);

		System.out.println(Arrays.toString(levelOrder(root).toArray()));

	}

	public static List<List<Integer>> levelOrder_outputLevelByLevel(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelList = new ArrayList<>();

			while(levelSize > 0) {
				Node curr = queue.poll();
				if (curr.leftChild!=null) {
					queue.add(curr.leftChild);
				}
				if (curr.rightChild != null) {
					queue.add(curr.rightChild);
				}
				levelList.add(curr.value);
				levelSize--;
			}
			res.add(levelList);
		}
		return res;
	}

	public static List<Integer> levelOrder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return new ArrayList<>();
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);


		while (!queue.isEmpty()) {
			Node polledNode = queue.poll();
			res.add(polledNode.value);
			if (polledNode.leftChild != null)
				queue.add(polledNode.leftChild);
			if (polledNode.rightChild != null)
				queue.add(polledNode.rightChild);
		}
		return res;
	}
}
