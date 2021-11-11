## Linked List

| Problem  | URL| Description|
| :------------ |:---------------| :-----|
| xxx | [xxx](../src/main/java/linkedLists/xxx.java) | Desc |
| RemoveDuplicatesSortedLL | [RemoveDuplicatesSortedLL](../src/main/java/linkedLists/RemoveDuplicatesSortedLL.java) | Desc |
| RemoveDuplicatesUnsortedLinkedList | [RemoveDuplicatesUnsortedLinkedList](../src/main/java/linkedLists/RemoveDuplicatesUnsortedLinkedList.java) | Given linked list remove duplicates |
| FindMidInLL | [FindMidInLL](../src/main/java/linkedLists/FindMidInLL.java) | Two pointer technique to find mid |
| ReverseLinkedListIterative | [ReverseLinkedListIterative](../src/main/java/linkedLists/ReverseLinkedListIterative.java) | Reverse |
| Compare linked list | [CompareLinkedLists](../src/main/java/linkedLists/CompareLinkedLists.java) | Return true if 2 LL are equal values |
| DeleteMiddleNode | [DeleteMiddleNode](../src/main/java/linkedLists/DeleteMiddleNode.java) | Delete middle node of given LL and given middle node, delete it |
| DeleteNodeAtPosition | [DeleteNodeAtPosition](../src/main/java/linkedLists/DeleteNodeAtPosition.java) | Delete node at given position |
| Add Node at end | [InsertNodeAtEnd](../src/main/java/linkedLists/InsertNodeAtEnd.java) | Add Node at end of linked List |
| Add Node at position | [InsertAtPosition](../src/main/java/linkedLists/InsertAtPosition.java) | Add Node at end at given position |
| Get Node at position | [GetNodeAtPosition](../src/main/java/linkedLists/GetNodeAtPosition.java) | Get Node at given position |

## Singly linked list
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


