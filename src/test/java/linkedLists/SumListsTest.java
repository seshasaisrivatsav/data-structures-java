package linkedLists;

import org.junit.Assert;
import org.junit.Test;

public class SumListsTest {

    @Test
    public void test_recursive() {
        Node num1 = Node.listToLinkedList(new int[] {7, 1, 6});
        Node num2 = Node.listToLinkedList(new int[] {5, 9, 2});
        // 617 + 295 = 912
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_recursive(num1, num2, 0)), "2->1->9");


        Node num3 = Node.listToLinkedList(new int[] {9, 9, 9});
        Node num4 = Node.listToLinkedList(new int[] {9, 9, 9});
        // 999 + 999 = 1998
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_recursive(num3, num4, 0)), "8->9->9->1");

        Node num5 = Node.listToLinkedList(new int[] {1, 3});
        Node num6 = Node.listToLinkedList(new int[] {9, 9, 9});
        // 999 + 13 = 1030
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_recursive(num5, num6, 0)), "0->3->0->1");


        Node num7 = Node.listToLinkedList(new int[] {5, 6, 3});
        Node num8 = Node.listToLinkedList(new int[] {8, 4, 2});
        // 365 + 248 = 613
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_recursive(num7, num8, 0)), "3->1->6");

    }

    @Test
    public void test_iterative() {
        Node num1 = Node.listToLinkedList(new int[] {7, 1, 6});
        Node num2 = Node.listToLinkedList(new int[] {5, 9, 2});
        // 617 + 295 = 912
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_iterative(num1, num2)), "2->1->9");


        Node num3 = Node.listToLinkedList(new int[] {9, 9, 9});
        Node num4 = Node.listToLinkedList(new int[] {9, 9, 9});
        // 999 + 999 = 1998
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_iterative(num3, num4)), "8->9->9->1");

        Node num5 = Node.listToLinkedList(new int[] {1, 3});
        Node num6 = Node.listToLinkedList(new int[] {9, 9, 9});
        // 999 + 13 = 1030
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_iterative(num5, num6)), "0->3->0->1");


        Node num7 = Node.listToLinkedList(new int[] {5, 6, 3});
        Node num8 = Node.listToLinkedList(new int[] {8, 4, 2});
        // 365 + 248 = 613
        Assert.assertEquals(Node.print(SumLists.sumLists_reverse_iterative(num7, num8)), "3->1->6");


    }
}
