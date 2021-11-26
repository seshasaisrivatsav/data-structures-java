package linkedLists;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is palindrome
 */
public class Palindrome {
    public static void main(String[] args) {
        Node head = Node.listToLinkedList(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(detectPalindrome_stackApproach(head));
    }

    /**
     * Approach 1: Reverse the second half of the list and compare two halfs
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * @param head Node
     * @return boolean
     */
    public static boolean detectPalindrome_noExtraSpace(Node head) {
       Node slow = head;
       Node fast = head;

       while (fast!=null && fast.next!=null) {
           slow = slow.next;
           fast = fast.next.next;
       }

       // If the linked list has odd nodes then fast!=null
        if (fast!=null) {
            slow = slow.next;
        }

        Node rightReversed = reverseLinkedList(slow);

        while(rightReversed!=null) {
            if (rightReversed.data != head.data) {
                return false;
            }
            rightReversed = rightReversed.next;
            head = head.next;
        }
        return true;
    }



    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node rest = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }


    /**
     * Approach 2: Here we use additional data structure Stack where we store half the elements and check
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *  = Push half the elements into stack (using two pointer method)
     *  = With remaining elements of linked list, compare and return
     * @param head Node
     * @return boolean, true if the given linked list is a palindrome
     *
     * 1->2->3->2->1->null
     *       s
     *            f
     *
     * 1->2->2->1->null
     *       s
     *            f
     */
    public static boolean detectPalindrome_stackApproach(Node head) {
        Node slow = head;
        Node fast = head;

        // Initialize an Integer stack and push half of the elements
        Stack<Integer> headStack = new Stack<Integer>();
        while(fast!=null && fast.next!=null) {
            headStack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // fast!=null if the given list is ODD, then move slow ahead, so that we compare with remaining elements
        if (fast!=null) {
           slow = slow.next;
        }

        while(!headStack.isEmpty() && slow!=null) {
            if (headStack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }

        return (slow == null && headStack.isEmpty());

    }

    // TODO: Use recursive approach

}
