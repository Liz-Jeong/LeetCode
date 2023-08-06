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
        // 마지막 포인터가 null을 가리키지 않는다.
        // cycle이 있는 경우 특정 인덱스를 가리킨다.
        // last node의 index가 앞의 node를 가리키는지를 찾는다.
        // 각 노드의 next가 해당 노드의 index보다 크면 사이클?
        
        // base case
        if(head == null) return false;
        
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
    }
}