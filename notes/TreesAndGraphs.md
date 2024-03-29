## Trees And Graphs

| # | Problem | Description| Source | 
| :------------ |:---------------| :-----| :-----|
| 1 | [BinaryTree.java](../src/main/java/treesAndGraphs/BinaryTree.java) | Implementation of Binary Tree, Node, Graph Traversal, Find element, Delete element |
| 2 | [RouteBetweenNodes](../src/main/java/treesAndGraphs/RouteBetweenNodes.java) | Checks if a route exists in a directed graph between two nodes |
| 3 | [MinimalTree](../src/main/java/treesAndGraphs/MinimalTree.java) | Convert sorted array into BST |
| 4 | [ListOfDepths](../src/main/java/treesAndGraphs/ListOfDepths.java) | BFS and DFS approach to return list of  levels in binary tree|
| 5 | [CheckBalanced](../src/main/java/treesAndGraphs/CheckBalanced.java) | Check if a binary tree is balanced |
| 6 | [CheckIfGivenTreeIsBST](../src/main/java/treesAndGraphs/CheckIfGivenTreeIsBST.java) | Check if a given tree is BST |
| 7 | [PathSum](../src/main/java/treesAndGraphs/PathSum.java) | return true if a path exists from head to toe that matches given sum |
| 8 | [PathsWithSum](../src/main/java/treesAndGraphs/PathsWithSum.java) | return number of paths that add up to given sum |
| 9 | [FirstCommonAncestor](../src/main/java/treesAndGraphs/FirstCommonAncestor.java) | Find lowest common ancestor of 2 nodes |
| 10 | [CheckSubtree](../src/main/java/treesAndGraphs/CheckSubtree.java) | Create algorithm to determine if T2 is a subtree of T1 |
| 11 | [RandomNode](../src/main/java/treesAndGraphs/RandomNode.java) | Implement binary tree from scratch that also has a getRandomNode() method |
| 12 | [PrintTopViewOfTree](../src/main/java/treesAndGraphs/PrintTopViewOfTree.java) | Print top view of a tree |
| 13 | [InOrderTraversal](../src/main/java/treesAndGraphs/InOrderTraversal.java) | Recursive and Iterative Inoder traversal | Leetcode |
| 14 | [PreOrderTraversal](../src/main/java/treesAndGraphs/PreOrderTraversal.java) | PreOrderTraversal | CTCI/Leetcode |
| 15 | [PostOrderTraversal](../src/main/java/treesAndGraphs/PostOrderTraversal.java) | PostOrderTraversal | CTCI/Leetcode |
| 16 | [LevelOrderTraversal](../src/main/java/treesAndGraphs/LevelOrderTraversal.java) | Level order traversal | CTCI/Leetcode |
| 17 | [SymmetricTree](../src/main/java/treesAndGraphs/SymmetricTree.java) | Check if a given tree is symmetric around center | Leetcode |
| 18 | [SortedArrayToBinarySearchTree](../src/main/java/treesAndGraphs/SortedArrayToBinarySearchTree.java) | Convert an integer list in sorted order to BST with height | Leetcode |
| 19 | [NumberOfIslands](../src/main/java/treesAndGraphs/NumberOfIslands.java) | Determine the islands formed by 1s in a matrix | Leetcode |
| 20 | [TwoSumInBST](../src/main/java/treesAndGraphs/TwoSumInBST.java) | Two sum version in BST | Leetcode |
| 21 | [TwoSumInTwoBSTs](../src/main/java/treesAndGraphs/TwoSumInTwoBSTs.java) | Two sum in two BSTS. TODO - improve sol | Leetcode |
| 22 | [xxx](../src/main/java/treesAndGraphs/xxx.java) | Desc | Source |
| 23 | [xxx](../src/main/java/treesAndGraphs/xxx.java) | Desc | Source |
| 24 | [xxx](../src/main/java/treesAndGraphs/xxx.java) | Desc | Source |
| 25 | [xxx](../src/main/java/treesAndGraphs/xxx.java) | Desc | Source |



### Complete Binary Tree
Binary tree in which all levels are completely filled except the lowest one, which is filled from left
https://www.programiz.com/dsa/complete-binary-tree

### Min Heap v/s Max Heap
Both are Complete Binary Tree
- Min-Heap 
    - Root node has minimum value
    - Value of each node >= Value of parent
- Max-Heap
    - Root node has maximum value
    - Value of each node <= Value of parent
    
Time Complexity
- To get min/max element - O(1)
- Insert - O(log n) 
- Remove max/min element - O(log n) 

### Trie (Prefix Tree)
- Trie = Prefix tree
- n-ary tree in which characters are stored at each node.
- Each path down represents a word.
- The * nodes (null nodes ) indicate compelte words

- Tries are used to store the entire english language for quick prefix lookups
- While a Hash Table can look up if string is a valid word

- Lookup: O(K) - tried can check if a string of length K is a valid prefix in O(K) time
- Realworld hash might take O(K) time


### Graph
- Tree: is of type graph. No cycles
- Graph: collection of nodes with edges
- Types
    - Directed - One way
    - Undirected  - Two way
- Graph Representation
    - Adjacency List
    - Adjacency Matrix
    
#### Adjacency List
- Most common way to represent graph
- Every vertext or node, stores list of adjacent vertices
```java
class Graph {
    public Node[] nodes;
}

class Node {
    public String name;
    public Node[] children;
}
```
#### Adjacency Matrix
- It's an NxN boolean matrix, where N = Number of nodes
- matrix[i][j] - indicates an edge from i to j
- Undirected Graph - Matrix will be symmetric due to double edges
- Operations like BFS on adjacency matrix can be less efficient than operations on Adjacency List


## Graph Search

### DFS - Depth First Search
- Start at root or any arbitrarily selected node and explore each branch before moving on to next branch
- Preferred when we want to visit every node in graph
- Simpler
- Time Complexity = O(V) where V = number of Vertices / Nodes
```java
    void dfs(Node root) {
        if (root == null) return null;
        visit(root);
        root.visited = true;
        for (Node n in root.adjacent) {
            if (n.visited == false) {
                dfs(n);
            }
        }
    }
```
### BFS - Breadth First Search 
- Start at root or any arbitrarily selected node and explore each neighbor before going on to any of their children
- Preferred for finding path between nodes

```java
void bfs (Node root) {
    Queue queue = new Queue();
    root.marked = true;
    queue.enqueue(root);
    
    while(!queue.isEmpty()) {
        Node r = queue.dequeue();
        visit(r);
        for(Node n in r.adjacent) {
            if (n.marked == false) {
                n.marked = true;
                queue.enqueue(n);
            }
        }
    }   

}
```
Graph:
```
 0 -> 1 <- 2
 |.   | .  ^
 v  . v  . |
 5   >4 <- 3  
 ```
 Imagine arrow from 0->4, 1->3
 
 Adjacency List
 ```
 0: 1, 4, 5
 1: 4, 3
 2: 1
 3: 4, 2
```
 
DFS(0)
 ```java
 0
  1
   3
    2
    4
 5
```

BFS
```java
0
1
4
5
3
2
```

### Bidirectional Search
- Used to find shortest path between source and destination
- It runs two simultaneous BFS 
- When searches collide we find the path


### Tree traversals
- [in order](https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/)
- [pre order](https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/)
- [post order](https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/)
