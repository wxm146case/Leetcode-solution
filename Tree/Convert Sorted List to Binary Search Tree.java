//Convert Sorted List to Binary Search Tree

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {   
        int size = 0;
        cur = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        
        return toBST(size);
    }
    
    private TreeNode toBST(int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = toBST(size / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = toBST(size - (size / 2) - 1);
        root.left = left;
        root.right = right;
        
        return root;
        
    }
    
}

//method 2
public class Solution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null) return null;
    return toBST(head,null);
}
public TreeNode toBST(ListNode head, ListNode tail){
    ListNode slow = head;
    ListNode fast = head;
    if(head==tail) return null;
    
    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head,slow);
    thead.right = toBST(slow.next,tail);
    return thead;
}
}