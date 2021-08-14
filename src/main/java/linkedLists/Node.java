package linkedLists;

public class Node {
	int data;
	Node next;

	public Node(int d) {
		data = d;
		next = null;
	}

	public static Node listToLinkedList(int[] A) {
		Node result = new Node(A[0]);
		Node temp = result; // save the result in `temp` for iterating and having a reference to result

		for (int i=1; i<A.length; i++){
			temp.next = new Node(A[i]);
			temp = temp.next;
		}
		return result;
	}

	public static String print(Node head) {
		StringBuilder res = new StringBuilder();
		while(head != null) {
			res.append(head.data).append("->");
			head = head.next;
		}
		return res.substring(0, res.length()-2);
	}
	
}
