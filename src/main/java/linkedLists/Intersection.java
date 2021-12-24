package linkedLists;

/**
 * Given two singly linked lists, determine if they intersect
 * Return the intersecting node
 */
public class Intersection {
    public static void main(String[] args) {
        Node intersectingNode = Node.listToLinkedList(new int[]{99, 5, 4, 6});

        Node node1 = Node.listToLinkedList(new int[]{1, 2, 3, 4, 5});
        Node node2 = Node.listToLinkedList(new int[]{4, 5, 6});

        Node node1Head = node1;
        Node node2Head = node2;

        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = intersectingNode;

        while (node2.next != null) {
            node2 = node2.next;
        }
        node2.next = intersectingNode;

        // NOTE     node1Head = 1-2-3-4-5-99-5-4-6
        //          node2Head = 4-5-6-99-5-4-6
        // Where common Node = 99

        System.out.println(Node.print(getMergingNode(node1Head, node2Head)));


        Node intersectingNodeTwo = Node.listToLinkedList(new int[]{4, 5, 4});
        Node node3 = Node.listToLinkedList(new int[] {2, 2});
        Node node4 = Node.listToLinkedList(new int[] {2, 2});

        Node node3Head = node3;
        Node node4Head = node4;

        node3Head.next.next = intersectingNodeTwo;
        node4Head.next.next = intersectingNodeTwo;

        System.out.println(Node.print(getIntersectionNodeMyWay(node3Head, node4Head)));
        System.out.println(Node.print(getMergingNode(node3Head, node4Head)));
        System.out.println(Node.print(getMergingNodeElegant(node1Head, node2Head)));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    //                      Solution
    ///////////////////////////////////////////////////////////////////////////////////////////
    public static Node getMergingNodeElegant(Node head1, Node head2) {
        Node h1 = head1;
        Node h2 = head2;
        while (h1 != h2) {
            h1 = (h1 == null) ? head2 : h1.next;
            h2 = (h2 == null) ? head1: h2.next;
        }
        return h1;
    }
    /**
     * Approach:
     *  - Create a Result class (that has members tailNode, and length)
     *  - If the final node in either is not same, it means there's no common node
     *  - else, move the larger node
     * @param head1 Node
     * @param head2 Node
     * @return Node
     */
    public static Node getMergingNode(Node head1, Node head2) {
        Result head1Res = getTailNodeAndLength(head1);
        Result head2Res = getTailNodeAndLength(head2);

        // If the final tail node is not the same it means that there is no intersection
        if (head1Res.finalNode != head2Res.finalNode) {
            return null;
        }

        // Set the pointer to start of each linked list
        Node smallNode = head1Res.length > head2Res.length ? head2 : head1;
        Node largeNode = head1Res.length < head2Res.length ? head2 : head1;

        // Advance the larger linked list by difference of length
        int diff =  Math.abs(head1Res.length - head2Res.length);
        while(diff > 0 && largeNode !=null) {
            largeNode = largeNode.next;
            diff --;
        }


        while (smallNode != largeNode) {
            smallNode =smallNode.next;
            largeNode = largeNode.next;
        }
        return largeNode;
    }

    static class Result {
        int length;
        Node finalNode;

        Result(int length, Node finalNode) {
            this.length = length;
            this.finalNode = finalNode;
        }
    }

    public static Result getTailNodeAndLength(Node head) {
        int length = 1;
        // 1 -> 2 -> 3
        // h    h   h
        while (head.next != null) {
            length ++;
            head = head.next;
        }
        return new Result(length, head);
    }

    public static Node getIntersectionNodeMyWay(Node headA, Node headB) {
        Node n1 = headA;
        Node n2 = headB;
        int n1Size = getSize(n1);
        int n2Size = getSize(n2);

        Node bigger = n1Size > n2Size ? n1: n2;
        Node smaller = n1Size <= n2Size ? n1: n2;

        int diff = Math.abs(n1Size-n2Size);
        while (diff > 0) {
            bigger = bigger.next;
            diff--;
        }


        while(bigger!=null && smaller!=null ) {
            if (bigger == smaller) {
                return bigger;
            }
            bigger = bigger.next;
            smaller = smaller.next;
        }

        return null;
    }

    public static int getSize(Node head) {
        int res = 0;
        while(head!=null) {
            res = res + 1;
            head = head.next;
        }
        return res;
    }
}
