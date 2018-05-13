//House Robber III

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
    class Result {
        int rob;
        int notrob;
        public Result(int rob, int notrob) {
            this.rob = rob;
            this.notrob = notrob;
        }
    }
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result res = dfsHelper(root);
        return Math.max(res.rob, res.notrob);
    }
    
    private Result dfsHelper(TreeNode root) {
        Result result = new Result(0,0);
        if (root == null) {
            return result;
        }
        Result left = dfsHelper(root.left);
        Result right = dfsHelper(root.right);
        
        result.rob = left.notrob + right.notrob + root.val;
        result.notrob = Math.max(left.rob, left.notrob) + Math.max(right.rob, right.notrob);
        
        return result;
        
        
    }
}