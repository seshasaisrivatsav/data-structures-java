package linkedLists;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K sorted lists
 * https://www.techiedelight.com/efficiently-merge-k-sorted-linked-lists/
 *
 * Min Heap = complete binary tree in which value in each internal node is smaller than equal to values in children
 *
 */
public class MergeKLists {
    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        // [[1,4,5],[1,3,4],[2,6]]
        Node n1 = Node.listToLinkedList(new int[] {1, 4, 5});
        Node n2 = Node.listToLinkedList(new int[] {1, 3, 4});
        Node n3 = Node.listToLinkedList(new int[] {2, 6});
        Node[] lists = new Node[]{ n1, n2, n3 };
        System.out.println("Expected: 1->1->2->3->4->4->5->6 Actual: " + Node.print(mergeKLists.mergeKLists_divideConquer(lists)));


        Node n4 = Node.listToLinkedList(new int[] {1, 4, 5});
        Node n5 = Node.listToLinkedList(new int[] {1, 3, 4});
        Node n6 = Node.listToLinkedList(new int[] {2, 6});
        Node[] lists1 = new Node[]{ n4, n5, n6 };
        System.out.println("Expected: 1->1->2->3->4->4->5->6 Actual: " + Node.print(mergeKLists_priorityQueue(lists1)));
    }

    // ------------ vvv 1. Using Divide and Conquer vvv ----------- //
    /**
     * Time Complexity: O (N log K) where K = number of linked lists N = Total number of nodes
     * Space Complexity: O(1) - if iterative merge routine is used
     * @param lists Node[] lists List of linked lists
     * @return Node head of the resultant
     */
    public Node mergeKLists_divideConquer(Node[] lists) {
        if(lists.length == 0) return null;
        int start = 0;
        int end = lists.length - 1;
        return mergeKListsUtil(lists, start, end);
    }

    public Node mergeKListsUtil(Node[] lists, int start, int end){
        if (start < end){
            int mid = (start + end)/2;
            Node l = mergeKListsUtil(lists, start, mid);
            Node r = mergeKListsUtil(lists, mid + 1, end);
            // return mergeRoutine_recur(l, r);
            return mergeRoutine_iterative(l, r);
        } else {
            return lists[start];
        }
    }

    // Takes two sorted lists and merges them
    public Node mergeRoutine_recur(Node n1, Node n2){
        if (n1==null) { return n2; }
        if (n2==null) { return n1; }
        Node res;
        if (n1.data < n2.data){
            res = n1;
            res.next = mergeRoutine_recur(n1.next, n2);
        } else {
            res = n2;
            res.next = mergeRoutine_recur(n1, n2.next);
        }
        return res;
    }

    public Node mergeRoutine_iterative(Node n1, Node n2) {
        if (n1==null) { return n2; }
        if (n2==null) { return n1; }
        Node res = new Node(-1);
        Node returnRes = res;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                res.next = n1;
                n1 = n1.next;
            } else {
                res.next = n2;
                n2 = n2.next;
            }
            res = res.next;
        }

        while (n1 != null) {
            res.next = n1;
            n1 = n1.next;
            res = res.next;
        }

        while (n2 != null) {
            res.next = n2;
            n2 = n2.next;
            res = res.next;
        }

        return returnRes.next;
    }
    // ------------ ^^^ Using Divide and Conquer ^^^ ----------- //


    // ------------ vvv 2. Using Priority Queue Min Heap  vvv ----------- //
    /**
     * Approach
     *  - Create min heap and insert first element of all k linked lists
     *  - As long as the min heap is not empty
     *      - remove the top min and add to the result
     *      - if there exists element in same linked list, insert into min heap
     *  - return head node
     *
     *  Time Complexity: O (N log K) K = number of linked lists N = number of elements
     *  Space Complexity: O(N) - creating new linked lists
     *
     * @param lists Node[] list
     * @return Node head of node after sorting
     */
    public static Node mergeKLists_priorityQueue(Node[] lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.data, o2.data);
            }
        });

        // initialize min heap
        for(Node node: lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        if (minHeap.isEmpty()) { return null; }


        Node dummy = new Node(0);
        Node follower = dummy;
        while (!minHeap.isEmpty()) {
            follower.next = minHeap.poll();
            follower = follower.next;
            if (follower.next != null) {
                minHeap.add(follower.next);
            }
        }
        return dummy.next;
    }
    // ------------ ^^^ Using Priority Queue Min Heap  ^^^ ----------- //


    // ------------ vvv Binary Search Iterative like vvv ----------//
    public static Node mergeKListsHelper(Node[] lists, int start, int end) {
        if (start < end) {
            int mid = (start+end)/2;
            Node leftMerged = mergeKListsHelper(lists, start, mid);
            Node rightMerged = mergeKListsHelper(lists, mid+1, end);
            return mergeHelper(leftMerged, rightMerged);
        } else {
            return lists[start];
        }
    }

    public static Node mergeHelper(Node n1, Node n2) {
        return null;
    }
}
