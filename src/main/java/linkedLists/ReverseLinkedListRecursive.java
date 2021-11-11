package linkedLists;

public class ReverseLinkedListRecursive {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		System.out.println("before reversal: " + Node.print(head));
		System.out.println("after reversal: " + Node.print(reverseLinkedListRecursive(head)));

	}

	// TODO: Fix this
	public static Node reverseLinkedListRecursive(Node head) {
		if (head.next!=null) {
			reverseLinkedListRecursive(head.next);
			head = head.next;
		}
		return head;
	}
}
