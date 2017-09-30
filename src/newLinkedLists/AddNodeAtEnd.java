package newLinkedLists;

public class AddNodeAtEnd {
	
	public static void main(String[] args) {
		Node a = new Node(5);
		a.next = new Node(6);
		a.next.next = new Node(7);
		a.next.next.next = new Node(8);
		
		//addNodeAtEnd(a, 9);
		long startTime = System.currentTimeMillis();
		int res = fibonacci(50);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}
	
	public static int fibonacci(int n) {
		if (n <= 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	
	
	public static void addNodeAtEnd(Node head, int data) {
		Node res = head;
		while(head.next!=null) {
			head = head.next;
		}
		head.next= new Node(data);
		
		
		while(res!=null) {
			System.out.println(res.data);
			res= res.next;
		}
	}

}
