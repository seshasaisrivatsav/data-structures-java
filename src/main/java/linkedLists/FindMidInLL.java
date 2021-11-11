package linkedLists;

public class FindMidInLL {
	public static void main(String[] args) {
		Node evenLL = Node.listToLinkedList(new int[] {1, 2, 3, 4});
		Node oddLL = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5});

		System.out.println(findMid(evenLL).data); // 2
		System.out.println(findMid(oddLL).data); // 3
	       
   }
   
   public static Node findMid(Node head) {
	   Node slow, fast;
	   fast = slow = head; // Initialize both slow and fast pointers to head
	   while(slow!=null && fast!=null) {
		   if(fast.next==null || fast.next.next==null) {
			   break;
		   }
		   slow=slow.next;
		   fast=fast.next.next;
	   }
	   return slow;
   }
}
