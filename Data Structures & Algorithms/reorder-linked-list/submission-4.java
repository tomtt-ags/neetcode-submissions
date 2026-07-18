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
    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        ListNode prev = null; 
        ListNode curr = slow.next;
        slow.next = null;  
        while(curr!=null){
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        ListNode temp = head; 
        while(prev != null){
            ListNode t = temp.next; 
            ListNode p = prev.next; 
            temp.next = prev; 
            prev.next = t; 
            temp = t; 
            prev = p; 
        }
    }
}
