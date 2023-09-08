/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        // base case
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        while(second != null) {
            ListNode temp = second.next;
            second.next = first;

            first = second;
            second = temp;
        }
        head.next = null;
        head = first;
        return head;
    }
}