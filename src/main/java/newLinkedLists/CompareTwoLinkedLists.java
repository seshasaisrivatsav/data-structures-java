package newLinkedLists;

/*
 * Compare two linked lists, return true iff they have values
 */
public class CompareTwoLinkedLists {
	
	public static void main(String[] args) {
		Node a = new Node(5);
		a.next = new Node(6);
		a.next.next = new Node(7);
		a.next.next.next = new Node(8);
		
		Node b = new Node(5);
		b.next = new Node(6);
		b.next.next = new Node(7);
		b.next.next.next = new Node(8);
		
		Node c = new Node(5);
		c.next = new Node(7);
		c.next.next = new Node(8);
		c.next.next.next = new Node(9);
		
		
		Node d = new Node(5);
		d.next = new Node(6);
		d.next.next = new Node(7);
		d.next.next.next = new Node(8);
		d.next.next.next.next = new Node(9);
		
		
		compareLinkedLists(a, d);
		
	}
	
	public static void compareLinkedLists(Node a, Node b) {
		
		while(a!=null && b!=null) {
			if(a.data == b.data && a.next!=null && b.next!=null) {
				a=a.next;
				b=b.next;
			}else {
				System.out.println("UnEqual");
				return;
			}
		}
		System.out.println("Equal");
	}

}
