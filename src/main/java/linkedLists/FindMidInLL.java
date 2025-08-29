package linkedLists;

/**
 * https://leetcode.com/submissions/detail/1752661418/
 */
public class FindMidInLL {
	public static void main(String[] args) {
		Node evenLL = Node.listToLinkedList(new int[] {1, 2, 3, 4});
		Node oddLL = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5});

		System.out.println(findMid(evenLL).data); // 2
		System.out.println(findMid(oddLL).data); // 3
	       
   }
   
   public static Node findMid(Node head) {
	   if (head==null) return head;
	   Node slow = head, fast = head;
	   while(fast!=null && fast.next!=null) {
		   slow = slow.next;
		   fast = fast.next.next;
	   }
	   return slow;
   }
}
