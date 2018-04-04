//reverse linkedlist


//recursion 1
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        return helper(prev, head);
        
        
    }
    private ListNode helper(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = cur.next;
        cur.next = prev;
        return helper(cur, temp);
    }    
}

//recursion 2
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        return helper(head);
    }
    
    private ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = helper(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

//iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            
            prev = head;
            head = temp;
        }
        return prev;
    }
}