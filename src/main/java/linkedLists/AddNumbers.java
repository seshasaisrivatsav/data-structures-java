package linkedLists;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
 Input: l1 = [0], l2 = [0]
Output: [0]


Example 2:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Example 3:
InputL l1 = [ 2,4,3] l2=[5,6,4]
Output = [7, 0, 8]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */


public class AddNumbers {

    static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args){
//        Node head1 = new Node(9);
//        head1.next = new Node(9);
//        head1.next.next = new Node(9);
//        head1.next.next.next = new Node(9);
//        head1.next.next.next.next = new Node(9);
//        head1.next.next.next.next.next = new Node(9);
//        head1.next.next.next.next.next.next = new Node(9);
//
//        Node head2 = new Node(9);
//        head2.next = new Node(9);
//        head2.next.next = new Node(9);
//        head2.next.next.next = new Node(9);
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node head2 = new Node(9);
        head2.next = new Node(9);
        head2.next.next = new Node(9);

        Node res = addTwoNumbers(head1, head2);
        while(res !=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    public static Node addTwoNumbers(Node l1, Node l2) {
        Node result = null; // Result Node
        Node referenceNode = null; // Temp Node to get a reference

        boolean carryOver = false;

        while(l1!=null || l2!=null) {
            int loopSum;
            int loopNodeValueTotal = 0;

            if (l1 != null) {
                loopNodeValueTotal = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                loopNodeValueTotal = loopNodeValueTotal + l2.val;
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
}
