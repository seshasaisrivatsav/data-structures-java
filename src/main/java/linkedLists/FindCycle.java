package linkedLists;

public class FindCycle {

	public static void main(String[] args) {
		// Cycle 1 -> 2 -> 3 -> 4 -> 5 -> 4
	    Node head1 = new Node(1);
	    head1.next = new Node(2);
	    head1.next.next = new Node(3);
	    head1.next.next.next = new Node(4);
	    head1.next.next.next.next = new Node(5);
	    head1.next.next.next.next.next = head1.next.next.next;



	    // No Cycle 1 -> 2 -> 3 -> 4 -> 5
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(5);

		detectCycle(head1); // Has cycle
		detectCycle(head2); // Does not have cycle
	}
	
	public static void detectCycle(Node head1){
		Node s, f;
		s = head1;
		f = head1;
		
       if (s == s.next){
          System.out.println("There is a cycle");
          return;
       }
                
		while(s!=null && f.next!=null)
		{
			s=s.next;
			f=f.next.next;
			
			if(s==null || f == null){
				System.out.println("no cycles");
				return;
			}
		
			if(s==f){
				System.out.println("There is a cycle");
				return;
			}
		}
		System.out.println("No Cycles");
	}
	
}

