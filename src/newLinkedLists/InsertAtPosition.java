package newLinkedLists;

public class InsertAtPosition {

	public static void main(String[] args) {
		Node head = new Node(7);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		 
		 
		int position = 3;
		Node element = new Node(121);
		printLinkedList(insertAt(head, element, position));
	}
	
	
	public static Node insertAt(Node head, Node element, int position) {
		Node res=head; Node temp;
		int count = 2;
		while(count <position) {
			
			head = head.next;
			count++;
			
		}
		temp = head.next;
		head.next = element;
		element.next = temp;
		
		return res;
	}
	
	
	public static void printLinkedList(Node head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}
