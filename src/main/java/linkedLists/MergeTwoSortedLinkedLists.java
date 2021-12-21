package linkedLists;

public class MergeTwoSortedLinkedLists {
	
	public static void main(String[] args) {
		Node n1= new Node(5);
		n1.next=new Node(7);
		n1.next.next=new Node(9);
		
		Node n2= new Node(6);
		n2.next=new Node(8);
		n2.next.next=new Node(10);

		System.out.println(Node.print( mergeTwoLists(n1, n2)));

		Node head1 = Node.listToLinkedList(new int[]{1, 3, 4});
		Node head2 = Node.listToLinkedList(new int[]{2, 7, 8});

		System.out.println(Node.print(mergeTwoListsIterative(head1, head2)));
	}

	public static Node mergeTwoListsIterative(Node list1, Node list2) {

		if (list1 == null) { return list2; }
		if (list2 == null) { return list1; }


		Node res = new Node(-100);
		Node pointer = res;

		while (list1 != null || list2 != null) {
			if (list1!=null && list2!=null) {
				if (list1.data <= list2.data) {
					res.next = list1;
					list1 = list1.next;
				} else {
					res.next = list2;
					list2 = list2.next;
				}
				res = res.next;
			}
			else if (list1!=null) {
				res.next = list1;
				break;
			}
			else if (list2!=null) {
				res.next = list2;
				break;
			}
		}
		return pointer.next;
	}
	// Recursive way. If N1 is null, return N2; If N2 is null, return N1.
	// Node res
	// if N1.data < N2.data; res=N1 res.next = fn(N1.next, N2)
	// else res = N2 res.next = fn(N1, N2.next)
	
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        Node res;
        if (l1.data < l2.data) {
        	res = l1;
        	res.next=mergeTwoLists(l1.next, l2);
        } else {
        	res=l2;
        	res.next=mergeTwoLists(l1, l2.next);
        }
        return res;
        
    }
}
