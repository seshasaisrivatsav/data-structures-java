package linkedLists;

import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeAtPositionTest {
    @Test
    public void test_null() {
        Assert.assertEquals(null, DeleteNodeAtPosition.deleteNodeAtPosition(null, 0));
    }

    @Test
    public void test_first_one() {
        String expected = Node.print(Node.listToLinkedList(new int[] {1, 2}));
        String actual = Node.print(DeleteNodeAtPosition.deleteNodeAtPosition(Node.listToLinkedList(
                new int[] {0, 1, 2}), 0));
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test_last_one() {
        String expected = Node.print(Node.listToLinkedList(new int[] {1, 2, 3, 4, 5}));
        String actual = Node.print(DeleteNodeAtPosition.deleteNodeAtPosition(Node.listToLinkedList(
                new int[] {1, 2, 3, 4, 5, 6}), 5));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_center() {
        String expected = Node.print(Node.listToLinkedList(new int[] {1, 2, 4, 5}));
        String actual = Node.print(DeleteNodeAtPosition.deleteNodeAtPosition(Node.listToLinkedList(
                new int[] {1, 2, 3, 4, 5}), 2));
        Assert.assertEquals(expected, actual);
    }
}
