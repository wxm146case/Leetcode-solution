//Path Sum III

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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            count += helper(node, sum);
        }
        return count;
    }
    private int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left, sum - node.val);
        int right = helper(node.right, sum - node.val);
        
        if (node.val == sum) {
            return 1 + left + right;
        } else {
            return left + right;
        }        
    }
}