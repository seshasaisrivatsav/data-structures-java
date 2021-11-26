package linkedLists;

public class RemoveDuplicatesSortedLL {
    public static void main(String[] args) {
//        Node node1 = Node.listToLinkedList(new int[] {1, 1, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 9});
        Node node2 = Node.listToLinkedList(new int[] {1, 1, 2, 3, 3});
//        System.out.println(Node.print(removeDupesSortedLL(node1)));
        System.out.println(Node.print(removeDupesSortedLL(node2)));
    }

    /**
     * Approach 1:
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * @param head Node
     * @return Node with removed duplicates
     */

    /*
    1-> 1 -> 2 -> 3 -> 3
    t
    c

    1-> 1 -> 2 -> 3 -> 3
        t
    c

    1-> 1 -> 2 -> 3 -> 3
             t
    c

    1------> 2 -> 3 -> 3
             t
    c


    1------> 2 -> 3 -> 3
             t
             c

    1------> 2 -> 3 -> 3
             t
             c

    1------> 2 -> 3 -> 3
                  t
             c

    1------> 2 -> 3 -> 3
                  t
                  c

    1------> 2 -> 3 -> 3
                       t
                  c

    1------> 2 -> 3 -> 3 -> null
                             t
                  c

    1------> 2 -> 3 ------> null
                             t
                  c

    1------> 2 -> 3 ------> null
                             t
                             c
     */
    public static Node removeDupesSortedLL(Node head) {
        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    // TODO: recursive way to remove duplicates
}
