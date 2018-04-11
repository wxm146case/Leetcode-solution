//Construct Binary Tree from String

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
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        
        int first = s.indexOf('(');
        int val = first == -1 ? Integer.valueOf(s) : Integer.valueOf(s.substring(0, first));
        
        TreeNode root = new TreeNode(val);
        if (first == -1) {
            return root;
        }
        int start = first;
        int countLeft = 0;
        
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countLeft++;
            }
            if (s.charAt(i) == ')') {
                countLeft--;
            }
            
            if (countLeft == 0 && start == first) {
                root.left = str2tree(s.substring(first + 1, i));
                start = i + 1;
            } else if (countLeft == 0) {
                root.right = str2tree(s.substring(start + 1, i));
            }           
        }
        return root;
    }
}