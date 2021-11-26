package linkedLists;

import java.util.HashSet;

// Given an unsorted linked list, remove duplicates

/**
 * If this is interview, ask if we need to preserver the order
 *
 * Order is preserved
 *  - Then use two loops O(n2)
 * Order is not preserved
 *  - Sort the LL
 */
public class RemoveDuplicatesUnsortedLinkedList {

	public static void main(String[] args) {
		Node head = Node.listToLinkedList(new int[] {9, 7, 9, 1, 8, 1, 7});
		System.out.println("Remove duplicates with no buffer:");
		System.out.println(Node.print(removeDupsNoBuffer(head)));
		System.out.println("Remove duplicates with buffer:");
		System.out.println(Node.print(removeDupsWithBuffer(head)));
	}

	/**
	 * Approach 1:
	 * 		Preserving the order, this removes duplicates
	 * 		Take two pointers `current` and `runner`
	 *
	 * Time Complexity: O(n2)
	 * Space Complexity: O(1)
	 *
	 * @param head Node with duplicates
	 * @return Node with duplicates removed
	 */
	/*
	Visual

	9->7->9->1->8->1->7  | curr iteration = 0, runner iteration 0
	c,r
	9->7->1->8->1->7  | curr iteration = 0, runner iteration 1 (here current.data == runner.next.data)
	c  r
	9->7->1->8->1->7  | curr iteration = 0, runner iteration 2
	c     r
	9->7->1->8->1->7  | curr iteration = 1, runner iteration 1
	   cr
	*/
	public static Node removeDupsNoBuffer(Node head) {
		Node current, runner;
		current = head;
		while(current != null) {
			runner = current;
			while(runner.next != null) {
				if (current.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		return head;
	}

	/**
	 * Approach 2: Using a hashset, remove
	 * 	Time Complexity: O(n2)
	 * 	Space Complexity: O(1)
	 *
	 * @param head Node
	 * @return Node with duplicates removed
	 */
	public static Node removeDupsWithBuffer(Node head) {
		HashSet<Integer> linkedListHashSet = new HashSet<Integer>();
		Node res = head;
		Node prev = null;
		while(head!=null) {
			if (linkedListHashSet.contains(head.data)) {
				prev.next = head.next;
			} else {
				linkedListHashSet.add(head.data);
				// you move prev only when adding elements to the hashset
				// for the first time as you need it when dupe is found
				prev = head;
			}
			head=head.next;
		}
		return res;
	}
}
