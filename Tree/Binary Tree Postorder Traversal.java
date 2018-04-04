//Binary Tree Postorder Traversal

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Guide> path = new Stack<>();
        path.push(new Guide(root, 0));
        
        while (!path.isEmpty()) {
            Guide cur = path.pop();
            if (cur.operation == 0) {
                path.push(new Guide(cur.node, 1));
                
                if (cur.node.right != null) {
                    path.push(new Guide(cur.node.right, 0));
                }
                if (cur.node.left != null) {
                    path.push(new Guide(cur.node.left, 0));
                }
            } else {
                res.add(cur.node.val);
            }
        }
        return res;
    }
    
    private class Guide{
        int operation;
        TreeNode node;
        public Guide(TreeNode node, int operation) {
            this.node = node;
            this.operation = operation;
        }
    }
}