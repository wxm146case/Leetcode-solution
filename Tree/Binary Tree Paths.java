//Binary Tree Paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, new String());
        return res;
    }
    private void helper(TreeNode root, List<String> res, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        path = path + root.val + "->";
        if (root.left != null) {
            helper(root.left, res, path);
        }
        if (root.right != null) {
            helper(root.right, res, path);
        }
        
    }
}