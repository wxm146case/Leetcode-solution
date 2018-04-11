//Construct Binary Tree from Preorder and Inorder Traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructHelper(preorder,0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode constructHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int position = findIndex(inorder, preorder[preStart]);
        TreeNode left = constructHelper(preorder, preStart + 1, preStart + (position - inStart), inorder, inStart, position - 1);
        TreeNode right = constructHelper(preorder, preStart + (position - inStart) + 1, preEnd, inorder, position + 1, inEnd);
        
        root.left = left;
        root.right = right;
        
        return root;
        
    }
    private int findIndex(int[] inorder, int target) {
        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}