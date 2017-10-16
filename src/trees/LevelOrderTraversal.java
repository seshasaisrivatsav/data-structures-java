package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.leftChild = new Node(10);
		root.rightChild = new Node(15);
		root.leftChild.leftChild = new Node(20);
		root.leftChild.rightChild = new Node(25);
		root.rightChild.leftChild = new Node(30);
		root.rightChild.rightChild = new Node(35);

		root.rightChild.rightChild.rightChild = new Node(40);
		root.rightChild.rightChild.rightChild.rightChild = new Node(45);

		LevelOrder(root);

	}

	
	public static void LevelOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if(root==null) {
			System.out.println("Nothing to do here (goes on a rocket)");
		}
		q.add(root);
		while(!q.isEmpty()) {Node polledNode=q.poll();
			System.out.print(polledNode.key+" ");
			if(polledNode.leftChild !=null)
				q.add(polledNode.leftChild);
			if(polledNode.rightChild !=null)
				q.add(polledNode.rightChild);
		}
		
	}
}
