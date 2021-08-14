package linkedLists;

public class RemoveDupsNoBuffer {
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
		
		//if(head==null) return head;
		
		Node current, runner;
		
		current = head;
		while(current!=null) {
			runner=current;
			while(runner.next!=null) {
				if(current.data==runner.next.data) {
					runner.next=runner.next.next;
				}else {
					runner =runner.next;
				}
			}
			current=current.next;
		}
		return head;
	}
}
