package linkedLists;

/**
 * Write code to partition LL around value X such that
 * Problem A:  all nodes less than x come before all elements greater >=x
 * Problem B: all nodes left of x are lesser, all nodes right of X are greater than X
 */
public class PartitionLinkedList {

    public static void main(String[] args) {
        Node head = Node.listToLinkedList(new int[] {3, 5, 6, 5, 10, 2, 1});
        // Problem  A - with order
        Node headTwo = Node.listToLinkedList(new int[] {1, 4, 3, 2, 5, 2});
        System.out.println("before partition around x: "+ 3 + "=> " +Node.print(head));
        System.out.println("after partition around x: "+ 3 + "=> " + Node.print(partition_lessthanX_withOrder(headTwo, 3))); // O/P Should: 1, 2, 2, 4, 3, 5
        // Problem  B - without order
        System.out.println("\nbefore partition around x: "+ 5 + "=> " +Node.print(head));
        System.out.println("after partition around x: "+ 5 + "=> " + Node.print(partition_withoutOrder(head, 5)));

        // Problem  B - with order
        System.out.println("\nOrdered | before partition around x: "+ 5 + "=> " +Node.print(head));
        System.out.println("Ordered | after partition around x: "+ 5 + "=> " + Node.print(partition_withOrder(head, 5)));
    }

    /**
     * Problem A:
     * Partition in place a given LL, such that numbers are partitioned around given number and order is preserved
     *
     *  Space Complexity: O(1) // Since we simply remove nodes, and append them to new ones
     *  Time Complexity: O(n)
     * Approach:
     *  Here, the problem talks about partitioning around x such that
     *          - nodes with value less than x, must be to left of x
     *         - Note that it does not talk about larger ones
     *
     *         so,
     *          input:  1 -> 4 -> 3 -> 2 -> 5 -> 2      | x=3
     *          output: 1 -> 2 -> 2 -> 4 -> 3 -> 5
     *
     *        Here, note that 4 is to the left of 3 and we don't care about it, as we only care about values less than 3
     *
     * Solution:
     *  Take two pointers `before` and `after` to keep track of 2 linked lists
     *  Use it to created two separate lists and join them to return the answer
     *      - Initialize the two pointers `before` and `after` to dummy node
     *      - Iterate the original list using `head`
     *          - If a node's value pointed by head is lesser than x, it should be part of `before` list
     *          - else, move it to after
     *      - Once we're done with all nodes, merge the lists
     * @param head Node, given head
     * @param x, the node value around which the given list must be partitioned
     * @return partitioned Linked List
     */
    public static Node partition_lessthanX_withOrder(Node head, int x) {
        // We need to initialize two separate linked lists, and have reference to the head in beforeHead, afterHead
        Node beforeHead = new Node(0) ; // NOTE: it's imp that you initialize this Node so that you c
        Node afterHead = new Node(0);
        Node before = beforeHead; // before and after are the pointers
        Node after = afterHead;

        while(head!=null) {
            if (head.data < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }

    /**
     * Problem B:
     * Partition in place a given LL, such that numbers are partitioned around given number and order need not be preserved
     * @param head Node, given head
     * @param x, the node value around which the given list must be partitioned
     *
     * @return
     */
    public static Node partition_withoutOrder(Node head, int x) {
        Node tail = head;
        Node curr = head;

        while (curr!=null) {
            Node next = curr.next;
            if (curr.data < x) {
                curr.next = head;
                head = curr;
            } else {
                tail.next = curr;
                tail = curr;
            }
            curr = next;
        }
        tail.next = null;
        return head;
    }


    /**
     * Problem B:
     * Problem : Partition around x such that, values less than x are on left side, values greater than x are on right side
     * @param head
     * @param x
     * @return
     */
    public static Node partition_withOrder(Node head, int x) {
        Node smallerHead = null, smallerTail = null;
        Node equalHead = null, equalTail = null;
        Node largerHead = null, largerTail = null;

        while (head!=null) {
            if (head.data < x) {
                if (smallerHead == null) {
                    smallerHead = smallerTail = head;
                } else {
                    smallerTail.next = head;
                    smallerTail = head;
                }
            } else if (head.data == x) {
                if (equalHead == null) {
                    equalHead = equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = equalTail.next;
                }
            } else {
                if (largerHead == null) {
                    largerHead = largerTail = head;
                } else {
                    largerTail.next = head;
                    largerTail = head;
                }
            }
            head = head.next;
        }

        if (largerTail !=null) {
            largerTail.next = null;
        }

        if (smallerHead == null) {
            if (equalHead == null) {
                return largerHead;
            }
            equalTail.next = largerHead;
            return equalHead;
        }

        if (equalHead == null) {
            smallerTail.next = largerHead;
            return smallerHead;
        }

        smallerTail.next = equalHead;
        equalTail.next = largerHead;
        return smallerHead;
    }

}
