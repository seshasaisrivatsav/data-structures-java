package linkedLists;

public class InsertNodeAtEnd {
	
	public static void main(String[] args) {
		Node linkedList = Node.listToLinkedList(new int[]{5, 6, 7, 8, 9});
		System.out.println("==== before adding =========");
		System.out.println(Node.print(linkedList));
		System.out.println("==== after adding =========");
		Node linkedListAppended = addNodeAtEnd(linkedList, 11);
		System.out.println(Node.print(linkedListAppended));
	}
	
	public static Node addNodeAtEnd(Node head, int data) {
		Node res = head;
		while (head.next!=null) {
			head = head.next;
		}
		head.next= new Node(data);
		return res;
	}

}
