package linkedLists;

public class MergeTwoSortedLinkedLists {
	
	public static void main(String[] args) {
		Node n1= new Node(5);
		n1.next=new Node(7);
		n1.next.next=new Node(9);
		
		Node n2= new Node(6);
		n2.next=new Node(8);
		n2.next.next=new Node(10);
		
		Node res = mergeTwoLists(n1, n2);
		while(res.next!=null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
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
