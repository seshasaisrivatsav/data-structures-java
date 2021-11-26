package linkedLists;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {
    @Test
    public void test_palindromeNoExtraSpace_true() {
        Node n5 = Node.listToLinkedList(new int[]{1, 2, 3, 4, 3, 2, 1});
        Node n0 = Node.listToLinkedList(new int[]{1, 2, 3, 3, 2, 1});
        Node n1 = Node.listToLinkedList(new int[]{1, 2, 3, 2, 1});
        Node n2 = Node.listToLinkedList(new int[]{1, 2, 2, 1});
        Node n3 = Node.listToLinkedList(new int[]{1, 1});
        Node n4 = Node.listToLinkedList(new int[]{1});
        Assert.assertTrue(Palindrome.detectPalindrome_noExtraSpace(n0));
        Assert.assertTrue(Palindrome.detectPalindrome_noExtraSpace(n1));
        Assert.assertTrue(Palindrome.detectPalindrome_noExtraSpace(n2));
        Assert.assertTrue(Palindrome.detectPalindrome_noExtraSpace(n3));
        Assert.assertTrue(Palindrome.detectPalindrome_noExtraSpace(n4));
        Assert.assertTrue(Palindrome.detectPalindrome_noExtraSpace(n5));
    }

    @Test
    public void test_palindromeNoExtraSpace_false() {
        Node n5 = Node.listToLinkedList(new int[]{1, 2, 3, 4, 3, 3, 1});
        Node n0 = Node.listToLinkedList(new int[]{1, 2, 3, 3, 2, 8});
        Node n1 = Node.listToLinkedList(new int[]{1, 2, 3, 2, 7});
        Node n2 = Node.listToLinkedList(new int[]{1, 2, 2, 5});
        Node n3 = Node.listToLinkedList(new int[]{1, 2});
        Assert.assertFalse(Palindrome.detectPalindrome_noExtraSpace(n0));
        Assert.assertFalse(Palindrome.detectPalindrome_noExtraSpace(n1));
        Assert.assertFalse(Palindrome.detectPalindrome_noExtraSpace(n2));
        Assert.assertFalse(Palindrome.detectPalindrome_noExtraSpace(n3));
        Assert.assertFalse(Palindrome.detectPalindrome_noExtraSpace(n5));
    }

    @Test
    public void test_palindromeStackApproach_true() {
        Node n5 = Node.listToLinkedList(new int[]{1, 2, 3, 4, 3, 2, 1});
        Node n0 = Node.listToLinkedList(new int[]{1, 2, 3, 3, 2, 1});
        Node n1 = Node.listToLinkedList(new int[]{1, 2, 3, 2, 1});
        Node n2 = Node.listToLinkedList(new int[]{1, 2, 2, 1});
        Node n3 = Node.listToLinkedList(new int[]{1, 1});
        Node n4 = Node.listToLinkedList(new int[]{1});
        Assert.assertTrue(Palindrome.detectPalindrome_stackApproach(n0));
        Assert.assertTrue(Palindrome.detectPalindrome_stackApproach(n1));
        Assert.assertTrue(Palindrome.detectPalindrome_stackApproach(n2));
        Assert.assertTrue(Palindrome.detectPalindrome_stackApproach(n3));
        Assert.assertTrue(Palindrome.detectPalindrome_stackApproach(n4));
        Assert.assertTrue(Palindrome.detectPalindrome_stackApproach(n5));
    }

    @Test
    public void test_palindromeStackApproach_false() {
        Node n5 = Node.listToLinkedList(new int[]{1, 2, 3, 4, 3, 3, 1});
        Node n0 = Node.listToLinkedList(new int[]{1, 2, 3, 3, 2, 8});
        Node n1 = Node.listToLinkedList(new int[]{1, 2, 3, 2, 7});
        Node n2 = Node.listToLinkedList(new int[]{1, 2, 2, 5});
        Node n3 = Node.listToLinkedList(new int[]{1, 2});
        Assert.assertFalse(Palindrome.detectPalindrome_stackApproach(n0));
        Assert.assertFalse(Palindrome.detectPalindrome_stackApproach(n1));
        Assert.assertFalse(Palindrome.detectPalindrome_stackApproach(n2));
        Assert.assertFalse(Palindrome.detectPalindrome_stackApproach(n3));
        Assert.assertFalse(Palindrome.detectPalindrome_stackApproach(n5));
    }
}
