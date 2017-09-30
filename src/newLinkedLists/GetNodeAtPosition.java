package newLinkedLists;

public class GetNodeAtPosition {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		int position=7;
		getNodeAtPosition(head, position);
		
	}

	public static void getNodeAtPosition(Node head, int position) {
		int i=1;
		while(head!=null) {
			if(i == position) {
				System.out.println( head.data);
				return;
			}
			head = head.next;
			i++;
		}
		 System.out.println("Not found");
	}
}
