package newLinkedLists;

public class DeleteNodeAtPosition {
	public static void main(String[] args) {
		Node head = new Node(5);
		head.next = new Node(6);
		head.next.next = new Node(7);
		head.next.next.next = new Node (8);
		head.next.next.next.next = new Node (9);
		
		int pos = 3;
		
		deleteNodeAtPosition(head, pos);
		
	}
	
	public static void deleteNodeAtPosition(Node head, int pos) {
		Node attach; 
		Node original = head;
		int iterate=0;
		while(iterate<pos) {
			iterate++;
			head = head.next;
			
		}
		// TODO
		
		
		
		
	}

}
