//Path Sum II

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList<>());
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            return;
        }
        
        path.add(root.val);
        if (root.left != null) {
            helper(root.left, sum - root.val, res, path);
        }
        if (root.right != null) {
            helper(root.right, sum - root.val, res, path);
        }
        path.remove(path.size() - 1);
        
    }
}