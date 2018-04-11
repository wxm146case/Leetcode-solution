//Binary Tree Maximum Path Sum

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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root, max);
        return max[0];
    }
    
    public int helper(TreeNode root , int[] max) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(helper(root.left, max), 0);
        int right = Math.max(helper(root.right, max), 0);
        
        if (left + right + root.val > max[0]) {
            max[0] = left + right + root.val;
        }
        
        return Math.max(left, right) + root.val;
        
    }
}