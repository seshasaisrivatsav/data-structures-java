package linkedLists;

public class InsertAtPosition {

	public static void main(String[] args) {
		Node head = Node.listToLinkedList(new int[] {1, 2, 3, 4});
		int position = 4;
		Node element = new Node(11);
		System.out.println(Node.print(insertAt(head, element, position)));
	}
	
	
	public static Node insertAt(Node head, Node element, int position) {
		if (position == 0) {
			element.next = head;
			return element;
		}
		Node res = head;
		Node temp;
		int count = 1;
		while(count<position) {
			head = head.next;
			count++;
		}
		temp = head.next;
		head.next = element;
		element.next = temp;
		
		return res;
	}

}
