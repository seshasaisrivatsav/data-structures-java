package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum-bsts/solution/
 *
 * Given the roots of two binary search trees, root1 and root2,
 * return true if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 *
 *  Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 *  Output: false
 *
 *  Companies: Amazon
 */
// TODO: Better this solution
public class TwoSumInTwoBSTs {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> one = new ArrayList<>();
        inOrderTraversal(root1, one);
        List<Integer> two = new ArrayList<>();
        inOrderTraversal(root2, two);
        for (int i=0; i<one.size(); i++) {
            if (binarySearch(two, target-one.get(i)) > -1) {
                return true;
            }
        }
        return false;


    }

    public void inOrderTraversal(TreeNode root, List<Integer> visited) {
        if (root!=null) {
            inOrderTraversal(root.left, visited);
            visited.add(root.val);
            inOrderTraversal(root.right, visited);
        }
    }

    public int binarySearch(List<Integer> nums, int ele) {
        int start = 0;
        int end = nums.size()-1;
        int mid;
        while (start <= end) {
            mid = (start + end)/2;
            if (ele < nums.get(mid)) {
                end = mid-1;
            } else if (ele > nums.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
