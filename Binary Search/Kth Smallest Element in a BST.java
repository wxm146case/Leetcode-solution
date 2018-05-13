//Kth Smallest Element in a BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int left = count(root.left);
        if (left >= k) {
            return kthSmallest(root.left, k);
        } else if (k > left + 1) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return root.val;
        }
    }
    
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}