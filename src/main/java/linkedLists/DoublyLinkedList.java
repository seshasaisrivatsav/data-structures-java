package linkedLists;

public class DoublyLinkedList {
    Node head, tail = null;
    class Node {
        int data;
        Node next;
        Node prev;

        Node (int data) {
            this.data = data;
        }
    }

    void add (int data) {
        Node newNode = new Node(data);
        // if list is empty, head, tail points to new node
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    void printNodes() {
        Node curr = head;
        if (head == null) {
            System.out.println("Empty List");
        } else {
            StringBuilder res = new StringBuilder();
            res.append("null<=>");
            while (curr != null) {
                res.append(curr.data).append("<=>");
                curr = curr.next;
            }
            System.out.println(res.append("null").toString());
        }
    }
}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);

        doublyLinkedList.printNodes();
    }
}