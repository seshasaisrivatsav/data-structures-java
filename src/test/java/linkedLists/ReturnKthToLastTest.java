package linkedLists;

import org.junit.Assert;
import org.junit.Test;

public class ReturnKthToLastTest {
    Node head = Node.listToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    @Test
    public void test_getKthLastIterative_success() {
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 0), 9);
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 1), 8);
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 2), 7);
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 3), 6);
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 4), 5);
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 5), 4);
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 6), 3);
    }

    @Test
    public void test_getKthLastIterative_failure() {
        Assert.assertEquals(ReturnKthToLast.getKthToLast_iterative(head, 110), -1000);
    }

    @Test
    public void test_getKthLastRecursive_success() {
        ReturnKthToLast.getKthToLast_recursive(head, 0); // prints 9
        ReturnKthToLast.getKthToLast_recursive(head, 1); // prints 8
        ReturnKthToLast.getKthToLast_recursive(head, 2); // prints 7
    }
}
