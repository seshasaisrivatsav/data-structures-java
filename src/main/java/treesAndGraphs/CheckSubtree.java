package treesAndGraphs;

/**
 *  Given two large trees T1, T2 where T1 > T2
 *  Create algorithm to determine if T2 is a subtree of T1
 *
 *  subtree = A tree T2 is subtree of T1 if there exists a node N in T1 such that the subtree of N is identical to T2
 *           if you cut off the tree at node N, the two trees would be identical
 */
public class CheckSubtree {
    public static boolean areTwoTreesIdentical(Node n1, Node n2) {
        if (n1 == null || n2 == null) { return true; }
        if (n1 !=null && n2 !=null) {
            if (n1.value == n2.value
                    && areTwoTreesIdentical(n1.leftChild, n2.leftChild)
                    && areTwoTreesIdentical(n1.rightChild, n2.rightChild)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if N2 is a sub tree of N1
     * @param N1 Node
     * @param N2 Node
     * @return boolean
     */
    public static boolean isSubtree(Node N1, Node N2) {
        if (N2 == null) { return true; } // as NULL can be a sub tree of N1
        if (N1 == null) { return false; } // if the main tree it self is null, return false

        if (areTwoTreesIdentical(N1, N2)) {
            return true;
        }

        return (isSubtree(N1.leftChild, N2) || isSubtree(N1.rightChild, N2));
    }
}
