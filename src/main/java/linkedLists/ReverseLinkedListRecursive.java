package linkedLists;

public class ReverseLinkedListRecursive {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		reverseLinkedListRecursive(head);
		
		//printLinkedList(reverseLinkedListRecursive(head));
		
	}
	
	public static void reverseLinkedListRecursive(Node head){
		if(head.next!=null) {
			reverseLinkedListRecursive(head.next);
			head = head.next;
		}
		
	 
		
		
	}
	
	public static void printLinkedList(Node head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

}
