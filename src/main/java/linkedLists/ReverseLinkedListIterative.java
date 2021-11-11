package linkedLists;

public class ReverseLinkedListIterative {
	public static void main(String[] args) {
		Node head = Node.listToLinkedList(new int[]{7, 2, 3, 4, 5, 6});
		System.out.println("input: " + Node.print(head));
		System.out.println("output: " + Node.print(reverseLinkedListIterative(head)));
	}

	public static Node reverseLinkedListIterative(Node head) {
		Node prev = null;
		Node current = head;
		Node forward = head.next;

		while (current != null) {
			current.next = prev;
			prev = current;
			current = forward;
			if (forward != null) { // IMP: Here only check for forward and not forward.next
				forward = forward.next;
			}
		}
		return prev;
	}
	
}


