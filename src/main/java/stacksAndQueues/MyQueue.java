package stacksAndQueues;

import java.util.NoSuchElementException;

/**
 * Queue = First In First Out
 * Methods
 *  - add(item)
 *  - remove()
 *  - peek()
 *  - isEmpty()
 *  V.V.I.P - be sure to check how to add and remove
 *  Uses
 *      - Queues are used in Breadth first search
 *      - Used in implementing cache
 */
public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    /*
    ========================
                             <=== NewItem (enqueue)
    ========================
    first               last
     */
    public void add(T item) {
        QueueNode<T> newItem = new QueueNode<>(item); // Step 1: create a new QueueNode and initialize it to data
        // Step 2: Add the element to last. If the last element is not null, add to next of last element or add to last
        if (last != null) {
            last.next = newItem;
        }
        last = newItem;
        // Step 3: If the first is null, assign the last node to first
        if (first == null) {
            first = last;
        }
    }

    /*
              ========================
  <=== item (dequeue)
              ========================
              first               last
       */
    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }


}
