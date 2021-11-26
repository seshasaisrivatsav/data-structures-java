package linkedLists;

public class ReturnKthToLast {
    public static void main(String[] args) {
        Node head = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        getKthToLast_recursive(head, 0);
        getKthToLast_recursive(head, 1);
        getKthToLast_recursive(head, 2);
        getKthToLast_recursive(head, 8);
    }

    /**
     * Approach 1: Recursive
     *      - As we recurse through LL and reach end, base case will return 0
     *      - With each passing back call through stack, add 1 and return
     *      - When count hits k, print the value
     *   Time Complexity: O(n)
     * @param head Node given node
     * @param k int position from last
     */

    public static int getKthToLast_recursive(Node head, int k) {
        if (head == null) {
            return -1; // here, return 0, if you want to pass 1 and expect the last element
        }
        int index = getKthToLast_recursive(head.next, k) + 1;

        if (index==k) {
            System.out.println(head.data);
        }
        return index;
    }

    /**
     * Approach 2: Iterative using two pointers (curr, follower)
     *            Here both pointers are 'k' nodes apart
     *            we move 'curr' k nodes into the list
     *            then move them both until curr.next is null
     * @param head
     * @param k
     */
    public static int getKthToLast_iterative(Node head, int k) {
        Node curr = head;
        Node follower = head; // we write it such that follower is 'pos' behind currr

        // take curr to pos-th position
        for (int i=0; i< k; i++) {
            if (curr == null) return -1000; // here if pos > length of the LL , check with interviewer
            curr = curr.next;
        }

        // We want to stop on last element, so we check for curr.next !=null and follower has our number
        while (curr.next != null) {
            curr = curr.next;
            follower = follower.next;
        }
        return follower.data;
    }


    /**
     * Approach 3: Iterative using two loops
     *  Dumb approach that just loops entire LL to get length
     *  Second time it gets (length - k)th element
     * @param head
     * @param pos
     * @return
     */
    public static int getKthToLastTrivial(Node head, int pos) {
        Node curr = head;
        int count = 0;
        while(curr != null) {
            curr = curr.next;
            count ++;
        }

        int loop = 0;
        while (head != null) {
            if (count-loop == pos) {
                return head.data;
            }
            head = head.next;
            loop ++;
        }
        return -1;
    }
}
