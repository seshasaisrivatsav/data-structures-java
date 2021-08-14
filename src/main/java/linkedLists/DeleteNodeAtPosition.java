package linkedLists;

/**
 * Given a linked list and a position, delete a node at given position
 *
 * position: 0 to linkedList.length
 */
public class DeleteNodeAtPosition {
	public static void main(String[] args) {
		Node head1 = Node.listToLinkedList(new int[] {1,2,3,4,5,6,7});
		System.out.println(Node.print(deleteNodeAtPosition(head1, 3)));

		Node head = Node.listToLinkedList(new int[] {1,2,3});
		System.out.println(Node.print(deleteNodeAtPosition(head, 2)));

		Node head2 = Node.listToLinkedList(new int[] {1,2,3});
		System.out.println(Node.print(deleteNodeAtPosition(head2, 0)));
	}
	
	public static Node deleteNodeAtPosition(Node head, int pos) {
		// Case 1: if head is null return
		if (head == null) return null;

		// Case 2: if position is 0, return next if available
		if (pos == 0) {
			if (head.next != null) {
				return head.next;
			}
			return null;
		}

		// Case 3: delete node at any other position
		Node attach = null;
		Node original = head;
		int iterate=0;
		while (iterate<pos) {
			iterate++;
			attach = head; // IMP
			head = head.next; // IMP
		}
		// When we reach the end
		if (head.next != null) {
			attach.next = head.next;
		} else {
			attach.next = null;
		}
		return original;
	}

}
