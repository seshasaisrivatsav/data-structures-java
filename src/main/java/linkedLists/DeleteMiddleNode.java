package linkedLists;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node evenLL = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5});
        System.out.println(Node.print(deleteMiddleNode(evenLL)));

        Node oddLL = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5, 6});
        System.out.println(Node.print(deleteMiddleNode(oddLL)));
        Node single = Node.listToLinkedList(new int[] {1});
        System.out.println(Node.print(deleteMiddleNode(single)));

        Node pair = Node.listToLinkedList(new int[] {1, 2});
        System.out.println(Node.print(deleteMiddleNode(pair)));
    }

    /**
     * Approach: Use Two Pointers
     *      - If head is null, return
     *      - If there are only 3 nodes, return mid
     *      - Else, take two pointers, start at head and one moves 2x as fast
     *
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * @param head Node, the head of linked liked
     * @return Node, the head of linked list with middle removed
     */
    /*

    // ODD
        1  ->  2  ->  3  ->  4  ->  5
        s
        f

        1  ->  2  ->  3  ->  4  ->  5
               s
                      f

        1  ->  2  ->  3  ->  4  ->  5
                      s
                                    f

        // EVEN
        1  ->  2  ->  3  ->  4  ->  5  ->  6
        s
        f

        1  ->  2  ->  3  ->  4  ->  5  ->  6
               s
                      f

        1  ->  2  ->  3  ->  4  ->  5  ->  6
                      s
                                    f
        1  ->  2  ->  3  ->  4  ->  5  ->  6
                      s
                                    f
     */
    public static Node deleteMiddleNode(Node head) {
        if (head == null) return null;
        if (head.next == null || head.next.next == null) return head;

        // Slow and fast pointers to reach middle
        Node slow = head;
        Node fast = head;


        // to find middle and previous of middle
        Node prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow; // prev will the middle node - 1
            slow = slow.next; // slow would be the middle node
        }

        // once middle is found, set prev.next to middle.next
        prev.next = slow.next;
        return head;
    }

    /**
     * CTCI
     * This version of problem takes mid Node of a linked list and simply removes it
     * @param givenNode
     */
    public static void deleteMiddle(Node givenNode) {
        // 1-> 2 -> 3 -> 4 -> 5
        // givenNode = 3
        // newNode = 4
        if (givenNode == null || givenNode.next == null) return;
        Node nextNodeToGivenNode = givenNode.next;
        givenNode.data = nextNodeToGivenNode.data; // 1-> 2 -> 4 -> 4 -> 5
        givenNode.next = nextNodeToGivenNode.next; // 1-> 2 -> 4 -> 5

    }
}
