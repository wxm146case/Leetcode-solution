//Serialize and Deserialize Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer data = new StringBuffer();;
        stringBuild(root, data);
        return data.toString();
    }
    
    private void stringBuild(TreeNode root, StringBuffer data) {
        if (root == null) {
            data.append("N").append(",");
            return;
        }
        data.append(root.val).append(",");
        stringBuild(root.left, data);
        stringBuild(root.right, data);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        Queue<String> queue = new LinkedList<>();
        
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        return treeBuild(queue);
    }
    private TreeNode treeBuild(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        
        String cur = queue.poll();
        if (cur.equals("N")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(cur));
            root.left = treeBuild(queue);
            root.right = treeBuild(queue);
            return root;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));