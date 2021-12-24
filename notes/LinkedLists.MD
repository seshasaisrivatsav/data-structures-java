## Linked List

| Problem  | URL| Description| Source | 
| :------------ |:---------------| :-----| :-----|
| RemoveDuplicatesUnsortedLinkedList | [RemoveDuplicatesUnsortedLinkedList](../src/main/java/linkedLists/RemoveDuplicatesUnsortedLinkedList.java) | Given linked list remove duplicates |
| RemoveDuplicatesSortedLL | [RemoveDuplicatesSortedLL](../src/main/java/linkedLists/RemoveDuplicatesSortedLL.java) | Desc |
| ReturnKthToLast | [ReturnKthToLast](../src/main/java/linkedLists/ReturnKthToLast.java) | Algo to find ktch to last element of singly linked list | CTCT |
| RemoveKthFromLast | [RemoveKthFromLast](../src/main/java/linkedLists/RemoveKthFromLast.java) | Removes Kth from Last | Leetcode |
| DeleteMiddleNode | [DeleteMiddleNode](../src/main/java/linkedLists/DeleteMiddleNode.java) | Delete middle node of given LL and given middle node, delete it |
| PartitionLL | [PartitionLinkedList](../src/main/java/linkedLists/PartitionLinkedList.java) | Use Two new initialized linked lists to partition given one around a number   |
| ReverseLinkedList | [ReverseLinkedList](../src/main/java/linkedLists/ReverseLinkedList.java) | Iterative and Recursive approach to reverse a LL|
| SumLists | [SumLists](../src/main/java/linkedLists/SumLists.java) | Forward and reverse sum of linked lists|
| Palindrome | [Palindrome](../src/main/java/linkedLists/Palindrome.java) | Check if a given list is palindrome|
| Intersection | [Intersection](../src/main/java/linkedLists/Intersection.java) | Given two LLs find the intersection point  | CTCI/Leetcode |
| FindCycle | [FindCycle](../src/main/java/linkedLists/FindCycle.java) | Find cycle if it's present in LL |
| FindMidInLL | [FindMidInLL](../src/main/java/linkedLists/FindMidInLL.java) | Two pointer technique to find mid |
| Compare linked list | [CompareLinkedLists](../src/main/java/linkedLists/CompareLinkedLists.java) | Return true if 2 LL are equal values |
| DeleteNodeAtPosition | [DeleteNodeAtPosition](../src/main/java/linkedLists/DeleteNodeAtPosition.java) | Delete node at given position |
| Add Node at end | [InsertNodeAtEnd](../src/main/java/linkedLists/InsertNodeAtEnd.java) | Add Node at end of linked List |
| Add Node at position | [InsertAtPosition](../src/main/java/linkedLists/InsertAtPosition.java) | Add Node at end at given position |
| Get Node at position | [GetNodeAtPosition](../src/main/java/linkedLists/GetNodeAtPosition.java) | Get Node at given position |
| MergeTwoSortedLinkedLists | [MergeTwoSortedLinkedLists](../src/main/java/linkedLists/MergeTwoSortedLinkedLists.java) | Merge two sorted linked lists | Leetcode |
| xxx | [xxx](../src/main/java/linkedLists/xxx.java) | Desc | Source |
| xxx | [xxx](../src/main/java/linkedLists/xxx.java) | Desc | Source |
| xxx | [xxx](../src/main/java/linkedLists/xxx.java) | Desc | Source |
| xxx | [xxx](../src/main/java/linkedLists/xxx.java) | Desc | Source |
| xxx | [xxx](../src/main/java/linkedLists/xxx.java) | Desc | Source |
| xxx | [xxx](../src/main/java/linkedLists/xxx.java) | Desc | Source |

## Singly linked list
=======
Singly linked list
```java
class Node {
    Node next = null;
    int data;
    
    Node (int data) {
        this.data = data;
    }   

}
```

## Helpers
```java
    public static Node listToLinkedList(int[] A) {
		Node result = new Node(A[0]);
		Node temp = result; // save the result in `temp` for iterating and having a reference to result

		for (int i=1; i<A.length; i++){
			temp.next = new Node(A[i]);
			temp = temp.next;
		}
		return result;
	}

	public static String print(Node head) {
		StringBuilder res = new StringBuilder();
		while(head != null) {
			res.append(head.data).append("->");
			head = head.next;
		}
		return res.substring(0, res.length()-2);
	}
```

![IMG_0126 (1)](https://user-images.githubusercontent.com/19309898/142739696-9325deb4-25d9-4e4f-9108-0cb23c51b338.png)