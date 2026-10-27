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
        // if(head.next == null || head == null) return; 
        // int length = 0; 
        // ListNode tmp = head; 
        // while(tmp != null) {
        //     length++; 
        //     tmp = tmp.next; 
        // }
        // tmp = head; 
        // int half = length/2;
        // int counter = 0;  
        // for(int i = 0; i < half-1; i++) {
        //     tmp = tmp.next; 
        // }
        ListNode fast = head; 
        ListNode slow = head; 
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }
        ListNode tmp2 = slow.next;
        slow.next = null;  
        slow = head; 
        //reverse 2nd half
        ListNode prev = null; 
        while(tmp2 != null){
            ListNode next = tmp2.next; 
            tmp2.next = prev; 
            prev = tmp2; 
            tmp2 = next; 
        }
        //time to reorder!!
        while(prev != null) {
            ListNode next = slow.next; 
            ListNode nextPrev = prev.next; 
            slow.next = prev;
            prev.next = next;  
            prev = nextPrev; 
            slow = next;
        }
        slow = head; 
    }
}
