package linkedLists;

import java.util.HashSet;

// Given an unsorted linked list, remove duplicates
public class RemoveDups {

	public static void main(String[] args) {
		Node head = new Node(9);
		head.next= new Node(7);
		head.next.next = new Node(9);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(8);
		head.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next = new Node(7);
		
		Node res = removeDups(head);
		while(res!=null) {
			System.out.print(res.data+" ");
			res=res.next;
		}
	}
	
	public static Node removeDups(Node head) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Node res= head;
		
		
		Node prev=null;
		
		while(head!=null) {
			if(hs.contains(head.data)) {
				prev.next = head.next;
			}else {
				hs.add(head.data);
				prev=head; // you move prev only when adding elements to the hashset for the first time as you need it when dupe is found
			}
			
			head=head.next;
		}
		
		return res;
	}
}
