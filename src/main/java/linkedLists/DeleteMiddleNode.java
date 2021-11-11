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
     * This variation of problem takes head of LL and removes mid
     * @param node
     * @return
     */
    public static Node deleteMiddleNode(Node node) {
        if (node == null) return null;
        if (node.next == null || node.next.next == null) return node;
        Node slow, fast, res;
        res = slow = fast = node;
        while (slow !=null && fast !=null) {
            if (fast.next == null || fast.next.next == null) {
                slow.next = slow.next.next; // Skip to next
                return res;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return res;
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
