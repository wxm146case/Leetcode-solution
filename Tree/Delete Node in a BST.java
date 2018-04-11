//Delete Node in a BST

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.left = root;
        
        TreeNode pre = dummy;
        TreeNode cur = root;
        
        while(cur != null && cur.val != key) {
            pre = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return dummy.left;
        }
        
        TreeNode target = cur;
        
        if (cur.left != null && cur.right != null) {
            pre = cur;
            cur = cur.right;
            while (cur.left != null) {
                pre = cur;
                cur = cur.left;
            }
            target.val = cur.val;
        }
        
        if (cur.left == null) {
            if (pre.left == cur) {
                pre.left = cur.right;
            } else {
                pre.right = cur.right;
            }
        } else {
            if (pre.left == cur) {
                pre.left = cur.left;
            } else {
                pre.right = cur.left;
            }
        }
        
        return dummy.left;
    }
}


//recursion method
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}