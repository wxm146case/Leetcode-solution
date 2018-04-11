//Closest Binary Search Tree Value

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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        double cur = root.val;
        double differ = Math.abs(root.val - target);
        if (cur > target) {
            if (root.left != null) {
                TreeNode scan = root.left;
                while (scan.right != null) {
                    scan = scan.right;
                }
                double left = Math.abs(scan.val - target);
                if (left < differ) {
                    return closestValue(root.left, target);
                } else {
                    return root.val;
                }
            } else {
                return root.val;
            }
        } else if (cur < target) {
            if (root.right != null) {
                TreeNode scan = root.right;
                while (scan.left != null) {
                    scan = scan.left;
                }
                double right = Math.abs(scan.val - target);
                if (right < differ) {
                    return closestValue(root.right, target);
                } else {
                    return root.val;
                }
            } else {
                return root.val;
            }
        } else {
            return root.val;
        }      
    }
}