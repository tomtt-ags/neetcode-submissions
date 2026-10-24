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
        if(head.next == null || head == null) return; 
        int length = 0; 
        ListNode tmp = head; 
        while(tmp != null) {
            length++; 
            tmp = tmp.next; 
        }
        tmp = head; 
        int half = length/2;
        int counter = 0;  
        for(int i = 0; i < half-1; i++) {
            tmp = tmp.next; 
        }
        ListNode tmp2 = tmp.next;
        tmp.next = null;  
        tmp = head; 
        //reverse 2nd half
        ListNode prev = null; 
        while(tmp2 != null){
            ListNode next = tmp2.next; 
            tmp2.next = prev; 
            prev = tmp2; 
            tmp2 = next; 
        }
        //time to reorder!!
        ListNode tail = null; 
        while(tmp != null) {
            ListNode next = tmp.next; 
            ListNode nextPrev = prev.next; 
            tmp.next = prev;
            prev.next = next;  
            prev = nextPrev; 
            tmp = next;
        }
        tmp = head; 
        if(prev != null){
            while(tmp.next != null){
                tmp = tmp.next; 
            }
            tmp.next = prev; 
        }
    }
}
