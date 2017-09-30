package newLinkedLists;

public class ReverseLinkedListIterative {
	public static void main(String[] args) {
		Node head = new Node(7);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		 
		 
		printLinkedList(reverseLinkedListIterative(head));
		
	}
	
	public static Node reverseLinkedListIterative(Node head) {
		Node prev = null;
		Node curr = head;
		Node forward = head.next;
		
		while(curr!=null) {
			curr.next = prev;
			prev = curr;
			curr = forward;
			if(forward!=null)
				forward = forward.next;
			 
			 
		}
		
		return prev;
		 
	}
	
	
	public static void printLinkedList(Node head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	
}


