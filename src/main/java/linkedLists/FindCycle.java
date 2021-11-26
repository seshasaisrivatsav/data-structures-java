package linkedLists;

public class FindCycle {

	public static void main(String[] args) {
		/*						_______
								|      |
				1 -> 2 -> 3 -> 4 -> 5 -/
		 */
	    Node head1 = new Node(1);
	    head1.next = new Node(2);
	    head1.next.next = new Node(3);
	    head1.next.next.next = new Node(4);
	    head1.next.next.next.next = new Node(5);
	    head1.next.next.next.next.next = head1.next.next.next;

		detectCycle(head1); // Has cycle
		System.out.println("loop length: " + detectCycleWithLength(head1));

		// No Cycle 1 -> 2 -> 3 -> 4 -> 5
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(5);

		detectCycle(head2); // Does not have cycle
		//           -- 6 <-- 11 <-- 4
		//           |              |
		// 9 -> 8 -> 7 -> 8 -> 5 -> 4
		Node head3 = new Node(9);
		head3.next = new Node(8);
		head3.next.next = new Node (7);
		head3.next.next.next = new Node(8);
		head3.next.next.next.next = new Node(5);
		head3.next.next.next.next.next = new Node(4);
		head3.next.next.next.next.next.next = new Node(4);
		head3.next.next.next.next.next.next.next = new Node(11);
		head3.next.next.next.next.next.next.next.next = new Node(6);
		head3.next.next.next.next.next.next.next.next.next = head3.next.next;

		System.out.println("loop length " + detectCycleWithLength(head3));
	}

	/**
	 * Approach: Floyd’s Cycle-Finding Algorithm
	 * 	Two pointers slow and fast, fast travels twice as fast
	 * 			Initialize both pointers to head initially
	 * 			if slow = slow.next, return cycle
	 * 			else, loop through advancing
	 * 	Time Complexity: O(n)
	 * 	Space Complexity: O(1)
	 * @param head Node
	 */
	public static void detectCycle(Node head){
		Node s, f;
		s = head;
		f = head;
		
       if (s == s.next){
          System.out.println("There is a cycle");
          return;
       }
                
		while(f.next!=null) {
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


	public static int detectCycleWithLength(Node head){
		Node s, f;
		s = head;
		f = head;

		if (s == s.next){
			System.out.println("There is a cycle");
			return 0;
		}

		while(f.next!=null) {
			s=s.next;
			f=f.next.next;

			if(s==null || f == null){
				System.out.println("no cycles");
				return 0;
			}

			if(s==f){
				System.out.println("There is a cycle");
				int loopLength = 1;
				Node temp = s;
				while (temp.next != s) {
					loopLength++;
					temp = temp.next;
				}
				return loopLength;
			}
		}
		System.out.println("No Cycles");
		return 0;
	}
}

