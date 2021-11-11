package linkedLists;

public class RemoveDuplicatesSortedLL {
    public static void main(String[] args) {
        Node node = Node.listToLinkedList(new int[] {1, 1, 2, 3, 4, 4, 4, 5});
        System.out.println(Node.print(removeDupesSortedLL(node)));
    }

    public static Node removeDupesSortedLL(Node head) {
        while(head != null) {
            if (head.data == head.next.data) {
                head = head.next;
            }
            head = head.next;
        }
        return head;
    }
}
