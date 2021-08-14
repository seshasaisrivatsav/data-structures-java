package linkedLists;

/*
 * Compare two linked lists, return true iff they have values
 * Time Complexity: O(n)
 */
public class CompareLinkedLists {
	
	public static void main(String[] args) {

		Node a = Node.listToLinkedList(new int[]{5, 6, 8});
		Node b = Node.listToLinkedList(new int[]{5, 6, 8});
		Node c = Node.listToLinkedList(new int[]{5, 6, 8, 9});
		Node d = Node.listToLinkedList(new int[]{5, 6, 7, 8, 9});

		System.out.println(compareLinkedLists(a, b)); // Equal
		System.out.println(compareLinkedLists(b, c)); // Unequal
		System.out.println(compareLinkedLists(a, d)); // Unequal

		Node a1 = Node.listToLinkedList(new int[]{5, 8});
		Node a2 = Node.listToLinkedList(new int[]{5, 8});
		System.out.println(compareLinkedLists(a1, a2)); // Unequal

	}
	
	public static boolean compareLinkedLists(Node a, Node b) {
		while(a!=null && b!=null) {
			if (a.data != b.data) {
				return false;
			}
			a = a.next;
			b = b.next;
		}
		// VVIP : Only return true if we reach full string. if we miss this 1->2->3 and 1->2 will return trye
		return a == null && b == null; // if the lists are identical, and b must be null at this point
	}
}
