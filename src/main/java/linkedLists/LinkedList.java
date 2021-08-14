package linkedLists;

public class LinkedList {
    Node head;  // head of list
    /**
     * Linked List Node
     */
    public static class Node {
        int data;
        Node next;
        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        } 
    }
    
    public static int getListLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static String print(Node head) {
        StringBuilder res = new StringBuilder();
        while(head != null) {
            res.append(head.data).append("->");
            head = head.next;
        }
        return res.substring(0, res.length()-2);
    }

    public static Node listToLinkedList(int[] A) {
        Node result = new Node (A[0]);
        Node temp = result; // save the result in `temp` for iterating and having a reference to result

        for(int i=1; i<A.length; i++){
            temp.next = new Node(A[i]);
            temp = temp.next;
        }

        return result;
    }
    
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(6);
        head.next.next = new Node(7);


        System.out.println("====== LinkedList Methods ========");
        System.out.println("getListLength: " + getListLength(head));
        System.out.println("print: " + print(head));
        System.out.println("listToLinkedList: " + print(listToLinkedList(new int[]{1, 2, 3, 4, 5})));
     }
     
}
