//Search Range In Binary Search Tree


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        
        List<Integer> left = searchRange(root.left, k1, k2);
        List<Integer> right = searchRange(root.right, k1, k2);
        
        if (root.val >= k1 && root.val <= k2) {
            res.addAll(left);
            res.add(root.val);
            res.addAll(right);
        } else if (root.val < k1) {
            res.addAll(right);
        } else  {
            res.addAll(left);
        }
        return res;
    }
}