package newLinkedLists;

public class deleteMe {

	
	  static class Node {
		int Key;
		Node next;
		Node(int key){
			this.Key = key;
		}
	}
	
	public static void main(String[] args) {
		Node N1 = new Node(5);
		N1.next = new Node(6);
		N1.next.next = new Node(7);
		
		
		Node N2 = new Node(5);
		N2.next = new Node(6);
		N2.next.next = new Node(7);
		
//		
//		
//		Node N2 = new Node(1);
//		N2.next = new Node(2);
//		N2.next.next = new Node(5);
//		N2.next.next.next = new Node(6);
//		N2.next.next.next.next = new Node(7);
		
		System.out.println(N1.Key);
		
		
		
		
	}
}
