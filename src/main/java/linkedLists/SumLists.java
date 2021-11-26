package linkedLists;

import java.util.Arrays;

/**
 * Problem 1: Add reversed LL eg: 7->1->6 +  5->9->2 =>  2->1->9 (i.e., 617+295 = 912)
 * Problem 2: Add forward LL  eg: 7->1->6 +  5->9->2 =>  1->3->0->8 (i.e., 716+592 = 1308)
 */
public class SumLists {

    public static void main(String[] args){
        Node num1 = Node.listToLinkedList(new int[] {7, 1, 6});
        Node num2 = Node.listToLinkedList(new int[] {5, 9, 2});

        System.out.println(" === Sum lists reverse ==");
        System.out.println(Node.print(sumLists_reverse_iterative(num1, num2))); // Expect 2 -> 1 -> 9

        System.out.println(Node.print(sumLists_reverse_recursive(num1, num2, 0))); // Expect 2 -> 1 -> 9



        System.out.println(" === Sum lists forward ==");
        Node num3 = Node.listToLinkedList(new int[] {7, 1, 6});
        Node num4 = Node.listToLinkedList(new int[] {5, 9, 2});
        System.out.println("addition of "+ Node.print(num3) + " and " + Node.print(num4));
        System.out.println(Node.print(sumLists_forward(num3, num4)));

        Node num5 = Node.listToLinkedList(new int[] {1, 9});
        Node num6 = Node.listToLinkedList(new int[] {9, 8, 1});
        System.out.println("addition of "+ Node.print(num5) + " and " + Node.print(num6));
        System.out.println(Node.print(sumLists_forward(num5, num6)));


    }

    /**
     * Problem 1: Add reversed LL eg: 7->1->6 +  5->9->2 =>  2->1->9 (i.e., 617+295 = 912)
     * Approach 1: Recursive way to solve sumLists*
     *  Time Complexity: O(m+n)
     *  Space Complexity: O(m+n)
     * @param num1 Node representing reverse number eg: 7->1->6 (means 617)
     * @param num2  Node representing reverse number eg: 5->9->2 (means 295)
     * @param carry int, initial carry is passed 0, since this is recursive, we pass the carry along
     * @return Node representing addition of num1 + num2 eg: 2->1->9 (means 912 = 617+295)
     */
    public static Node sumLists_reverse_recursive(Node num1, Node num2, int carry) {
        if (num1 == null && num2 == null && carry == 0) {
            return null;
        }

        Node res = new Node(0);

        int currSum = carry;

        if (num1 != null) {
            currSum = currSum + num1.data;
        }

        if (num2 != null) {
            currSum = currSum + num2.data;
        }

        res.data = currSum % 10;

        if (num1 != null || num2 != null) {
            Node l1 = num1 == null ? null: num1.next;
            Node l2 = num2 == null ? null: num2.next;
            int loopCarry = currSum >= 10 ? 1: 0;
            Node more = sumLists_reverse_recursive(l1, l2, loopCarry);
            res.next = more;
        }

        return res;
    }


    /**
     * Problem 1:  Reverse sum
     *  Approach 2: Iterative
     * @param l1
     * @param l2
     * @return
     */
    public static Node sumLists_reverse_iterative(Node l1, Node l2) {
        Node result = null; // Result Node
        Node referenceNode = null; // Temp Node to get a reference

        boolean carryOver = false;

        while(l1!=null || l2!=null) {
            int loopSum;
            int loopNodeValueTotal = 0;

            if (l1 != null) {
                loopNodeValueTotal = l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                loopNodeValueTotal = loopNodeValueTotal + l2.data;
                l2 = l2.next;
            }

            // If there is a carry over in previous iteration, increment
            if (carryOver) {
                loopNodeValueTotal ++;
            }

            if (loopNodeValueTotal >= 10) {
                loopSum = loopNodeValueTotal % 10;
                carryOver = true;
            } else {
                loopSum = loopNodeValueTotal;
                carryOver = false;
            }

            Node loopSumNode = new Node(loopSum);
            // For the first iteration, as referenceNode is null,
            if (referenceNode == null) {
                result = loopSumNode; // add the first node to result
                referenceNode = result; // refer result in reference node, which will be used in next iterations
            } else {
                referenceNode.next = loopSumNode;
                referenceNode = referenceNode.next;
            }

        }
        // For the last carry
        if (carryOver) {
            referenceNode.next = new Node(1);
        }
        return result;
    }


    ////////////////////////////////////////
    // Problem 2: Add numbers represented by LL
    /**
     * Approach
     *  1. If both nodes are of not of same length, add additional zeroes to make them of same length
     *  2. Reverse the lists
     *  3. Recursively add both lists
     *  4. Return the reverse result of above
     *
     *  Time Complexity: O(M+N)
     *  Space Complexity: O(M+N)
     * @param l1 Node
     * @param l2 Node
     * @return Node
     */
    public static Node sumLists_forward(Node l1, Node l2) {
        int l1Length = getNodeLength(l1);
        int l2Length = getNodeLength(l2);

        if (l1Length > l2Length) {
            l2 = addZeroesNode(l2, (l1Length-l2Length));
        }

        if (l2Length > l1Length) {
            l1 = addZeroesNode(l1, (l2Length-l1Length));
        }

        l1 = reverseLinkList(l1);
        l2 = reverseLinkList(l2);

        Node res = sumLists_reverse_recursive(l1, l2, 0);

        return reverseLinkList(res);
    }


    public static Node addZeroesNode(Node head, int zeroCt) {
        Node res = new Node(0);
        Node zeroNodeWithHead = res;
        while (zeroCt > 1) {
            res.next = new Node(0);
            res = res.next;
            zeroCt--;
        }
        res.next = head;
        return zeroNodeWithHead;
    }

    public static int getNodeLength(Node head) {
        int res = 0;
        while(head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

    public static Node reverseLinkList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverseLinkList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
