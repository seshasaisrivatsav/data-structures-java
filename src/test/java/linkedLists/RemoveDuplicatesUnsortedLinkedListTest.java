package linkedLists;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesUnsortedLinkedListTest {

    @Test
    public void test_removeDupsLL_noBuffer() {
        Node arg = Node.listToLinkedList(new int[] {1, 1, 1, 2, 3, 3, 4, 4, 5, 5 });
        Node expected = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5});
        Assert.assertEquals(Node.print(RemoveDuplicatesUnsortedLinkedList.removeDupsNoBuffer(arg)),
                Node.print(expected));
    }

    @Test
    public void test_removeDupsLL_buffer() {
        Node arg = Node.listToLinkedList(new int[] {1, 1, 1, 2, 3, 3, 4, 4, 5, 5 });
        Node expected = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5});
        Assert.assertEquals(Node.print(RemoveDuplicatesUnsortedLinkedList.removeDupsWithBuffer(arg)),
                Node.print(expected));
    }
}
