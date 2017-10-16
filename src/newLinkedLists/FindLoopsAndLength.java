package newLinkedLists;

public class FindLoopsAndLength {
	public static void main(String[] args) {
		Node head = new Node(5);
		head.next = new Node(6);
		head.next.next = new Node(7);
		head.next.next.next = new Node (8);
		head.next.next.next.next = new Node (9);
		head.next.next.next.next.next= new Node (10);
		head.next.next.next.next.next.next = head.next.next.next.next.next ;
		 
		
		findLoopLength(head);
		
	}

	private static void findLoopLength(Node head) {
		Node slow, fast;
		slow=fast=head;
		int count=0;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast )  {
//				System.out.println("Loop found at");
//				System.out.println("when loop found" + slow.data + " " + fast.data);
				slow=slow.next;
				System.out.println("aftrer moving slw once " + slow.data);
				count++;
				while(slow!=fast) {
					slow=slow.next;
					System.out.println("After slow moved twice " + slow.data);
					count++;
				}
				
				System.out.println(count);
				return;
			}
			
			
		}
		
		System.out.println("No Loop here");
		
	}
	
}
