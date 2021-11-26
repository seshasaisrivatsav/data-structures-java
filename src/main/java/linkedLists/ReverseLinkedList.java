package linkedLists;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node head = Node.listToLinkedList(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println("Input: " + Node.print(head));
		System.out.println("Iterative =>" + Node.print(reverseLinkedListIterative(head)));
		Node head2 = Node.listToLinkedList(new int[]{1, 2, 3, 4});
		System.out.println("Recursive =>" + Node.print(reverseLinkedListRecursive(head2)));
		
	}

	/**
	 * Approach 1: Reverse linked list iterative
	 *
	 *  Time complexity: O(n)
	 *  Space Complexity: O(1)
	 * Run down of
	 * 		1->2->3->null
	 * 	    c
	 * 	    h
	 *
	 * Iteration 1:
	 * 	    	f = 2->3->null  (with forward = curr.next)
	 *
	 * 	    null<-1->2->3->null (with curr.next = prev)
	 * 	  	   p  c  f
	 * 	  	      h
	 * 	  	null<-1->2->3->null (with prev = curr; curr = forward)
	 * 	  	  	  p  c
	 *  	  	  h  f
	 *	Iteration 2:
	 * 	  	null<-1<-2->3->null
	 * 	  	  	     p  c
	 *  	  	  h     f
	 *	Iteration 3:
	 * 	  	null<-1<-2<-3->null V.V.I.P -> Here prev will be at the at, so assign that to
	 * 	  	  	        p  c
	 *  	  	  h        f
	 * @param head Node
	 * @return Node reversed
	 */
	public static Node reverseLinkedListIterative(Node head) {
		Node prev = null;
		Node curr = head;
		Node forward = null;
		while(curr!=null) {
			forward = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forward;
		}
		head = prev;
		return head; // You could just return prev here too.
	}

	/**
	 * Approach 2: Reverse a linked list recursive
	 *
	 * V.V.I.P = See explanation here => ![IMG_0126 (1)](https://user-images.githubusercontent.com/19309898/142739696-9325deb4-25d9-4e4f-9108-0cb23c51b338.png)
	 * Steps:
	 * 	 Start with node curr as head
	 * 	 Step 1:BOUNDARY:
	 * 	 		1. If curr is null, return
	 * 	 		2. if curr.next == null, it means we've reached the end and that element must be head of new reversed list
	 *	Step 2: Recursively traverse the list
	 *	Step 3: Set curr.next.next to curr;
	 * 	Step 4: Set curr.next to null;
	 * https://www.baeldung.com/java-reverse-linked-list
	 * 	https://javarevisited.blogspot.com/2017/03/how-to-reverse-linked-list-in-java-using-iteration-and-recursion.html#axzz7CgBEb7rs
	 * @param curr Node
	 * @return Node head of reversed link list
	 */
	public static Node reverseLinkedListRecursive(Node curr) {
		if (curr == null) {
			return null;
		}
		if (curr.next == null) {
			return curr;
		}
		System.out.println("curr " +Node.print(curr));
		Node rest = reverseLinkedListRecursive(curr.next); // rec-step
		System.out.println("res " +Node.print(rest));
		curr.next.next = curr; // loop-step
		curr.next = null; // end-step
		System.out.println("curr " +Node.print(curr));
		System.out.println("res " +Node.print(rest));
		return rest;
	}
}


