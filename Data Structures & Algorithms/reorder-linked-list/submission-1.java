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
        // i need to reverse a linked list. 
        if (head == null || head.next == null) return;
        ListNode mid = head; 
        ListNode fast = head; 
        ListNode prev = null; 
        while(fast != null && fast.next != null){
            mid = mid.next; 
            fast = fast.next.next; 
        }
        ListNode temp = mid.next;
        mid.next = null; 
        ListNode rev = null; 
        while(temp!=null){
            ListNode next = temp.next; 
            temp.next = rev;
            rev = temp; 
            temp = next; 
        }
       ListNode first = head; 
       ListNode second = rev; 
       while(second != null){
        ListNode nxt = first.next; 
        ListNode revNxt = second.next; 
        first.next = second; 
        second.next = nxt; 
        first = nxt; 
        second = revNxt; 
       }
    }
}
