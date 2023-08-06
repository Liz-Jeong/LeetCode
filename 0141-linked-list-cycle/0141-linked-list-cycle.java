/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // base case
        if(head == null) return false;
        
        // 1. SET : TC - O(N), SC - O(N)
        Set<ListNode> set = new HashSet<>();
        
        while(head != null) {
            if(set.contains(head)) return true;
            
            set.add(head);
            head = head.next;
        }
        
        return false;
        
        // 2. TC - O(N), SC - O(1)
        /*
        // define slow and fast
        ListNode slow = head, fast = head;
        
        // traverse the list to see if there is a cycle
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
        }
        
        // there is no cycle
        return false;
        */
    }
}