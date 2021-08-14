package linkedLists;

import org.junit.Assert;
import org.junit.Test;

public class InsertAtPositionTest {
    @Test
    public void test_first_one() {
        String expected = Node.print(Node.listToLinkedList(new int[] {1, 2, 3, 4}));
        String actual = Node.print(InsertAtPosition.insertAt(Node.listToLinkedList(
                new int[] {2, 3, 4}), new Node(1), 0));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_last_one() {
        String expected = Node.print(Node.listToLinkedList(new int[] {1, 2, 3, 44}));
        String actual = Node.print(InsertAtPosition.insertAt(Node.listToLinkedList(
                new int[] {1, 2, 3}), new Node(44), 3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_middle() {
        String expected = Node.print(Node.listToLinkedList(new int[] {1, 2, 44, 3}));
        String actual = Node.print(InsertAtPosition.insertAt(Node.listToLinkedList(
                new int[] {1, 2, 3}), new Node(44), 2));
        Assert.assertEquals(expected, actual);
    }
}
