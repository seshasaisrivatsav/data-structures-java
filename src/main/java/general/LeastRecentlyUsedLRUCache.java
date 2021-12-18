package general;

import linkedLists.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU = Least Recently Used
 *     => Used to identify item that hasn't been used for longest time
 * Often implemented by pairing doubly linked list with hash map
 * Similar to Cache
 * Strengths
 *  - Super fast access - Stores in order of most recently used to least recently used
 *  - Super fast updates - Each time an item is acessed, updating cache takes O(1) time
 * Weaknesses
 *  - Space heavy: For n elements we need linked list of size n and hash map of size n
 *
 * Space: O(n)
 * get least recently used: O(1) - at tail of the list
 * access item: O(1)
 *
 * Implementation:g
 *  - Doubly Linked List:
 *      - Most recently used item is at the head of the list
 *      - Least recently used item is at the tail of the list
 *
 *  - Item Look up
 *      - Cache Hit
 *          - We first search for it in Hash Table, get the linked list node
 *          - move the item node to head of the linked list (as it's most recently used)
 *      - Cache Miss
 *          - Go to tail of linked list and remove it from list and hashmap (as it's least recently used)
 *          - create new item at head of LL
 *
 * https://www.interviewcake.com/concept/java/lru-cache
 */
public class LeastRecentlyUsedLRUCache {
    private int size;
    private int capacity;
    private Map<Integer, DoublyLinkedList> cacheMap = new HashMap<>();
    private DoublyLinkedList head;
    private DoublyLinkedList tail;

    public LeastRecentlyUsedLRUCache (int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoublyLinkedList();
        tail = new DoublyLinkedList();

        head.next = tail;
        tail.prev = head;
    }


   class DoublyLinkedList {
       int data;
       int key;
       DoublyLinkedList next;
       DoublyLinkedList prev;
   }

   private void addNode(DoublyLinkedList node) {
       // always add node right after head
       node.prev = head;
   }

   // Method 1: put
    public void put(int key, int val) {

    }

    // Method 2: get
    public int get(int key) {
        return 1;
    }

}
