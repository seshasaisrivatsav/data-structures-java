package linkedLists;


/**
 * Merge K sorted lists
 * https://www.techiedelight.com/efficiently-merge-k-sorted-linked-lists/
 */
public class MergeKLists {
    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        // [[1,4,5],[1,3,4],[2,6]]
        Node n1 = Node.listToLinkedList(new int[] {1, 4, 5});
        Node n2 = Node.listToLinkedList(new int[] {1, 3, 4});
        Node n3 = Node.listToLinkedList(new int[] {2, 6});
        Node[] lists = new Node[3];
        lists[0] = n1;
        lists[1] = n2;
        lists[2] = n3;
        System.out.println("Expected: 1->1->2->3->4->4->5->6 Actual: " + Node.print(mergeKLists.mergeKLists_divideConquer(lists)));
    }


    // ------------ vvv Using Divide and Conquer vvv ----------- //
    public Node mergeKLists_divideConquer(Node[] lists) {
        int start = 0;
        int end = lists.length - 1;
        return mergeKListsUtil(lists, start, end);
    }

    public Node mergeKListsUtil(Node[] lists, int start, int end){
        if(lists.length == 0) return null;
        if (start < end){
            int mid = (start + end)/2;
            Node l = mergeKListsUtil(lists, start, mid);
            Node r = mergeKListsUtil(lists, mid + 1, end);
            return mergeTwoLists(l, r);
        } else {
            return lists[start];
        }
    }

    // Takes two sorted lists and merges them
    public Node mergeTwoLists(Node l, Node r){
        if(l == null)
            return r;
        if(r == null)
            return l;
        Node newHead;
        if(l.data < r.data){
            newHead = l;
            newHead.next = mergeTwoLists(l.next, r);
        } else {
            newHead = r;
            newHead.next = mergeTwoLists(l, r.next);
        }
        return newHead;
    }

    // ------------ ^^^ Using Divide and Conquer ^^^ ----------- //
}
