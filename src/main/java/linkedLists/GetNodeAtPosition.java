package linkedLists;

public class GetNodeAtPosition {
	public static void main(String[] args) {
		Node head = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5, 6});
		int position=5;
		getNodeAtPosition(head, position); // 6
		
	}

	public static void getNodeAtPosition(Node head, int position) {
		int i=0;
		while(head!=null) {
			if(i == position) {
				System.out.println(head.data);
				return;
			}
			head = head.next;
			i++;
		}
		System.out.println("Not found");
	}
}
