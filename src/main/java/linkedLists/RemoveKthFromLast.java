package linkedLists;

public class RemoveKthFromLast {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val; }
    }

    /**
     * Approach: have two pointers that have distance n
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_leetCodeSol (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // create a new pointer with extra head for flexible movt

        ListNode fast = dummy;
        ListNode slow = dummy;

        // we're keeping n+1 distance so that we have access to where we want
        // to delete
        while ((n+1) > 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
    public ListNode removeNthFromEnd_myInitialApproach (ListNode head, int n) {
        if ((n==1 && head.next == null) ||
                (n==2 && head.next.next == null)) {
            return head.next;
        }

        ListNode p1 = head; // fast pointer
        ListNode p2 = head; // slow pointer

        // advances by n-1
        while (n > 1) {
            p1 = p1.next;
            n--;
        }

        // p3 travels 1 node behind p2
        ListNode p3 = p2;
        while (p1.next != null) {
            p1 = p1.next;
            p3 = p2;
            p2 = p2.next;
        }

        // if p2 hasn't advanced, it means that we're at the node to be deleted
        if (p2 == p3) {
            return p2.next;
        }

        // otherwise we skip p2
        p3.next = p2.next;
        return head;
    }
}
