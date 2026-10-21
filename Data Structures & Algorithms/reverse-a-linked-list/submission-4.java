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
        ListNode tmp = head; 
        if(tmp == null || tmp.next == null){
            return tmp; 
        }
        ListNode curr = tmp.next; 
        tmp.next = null; 
        while(curr != null) {
            ListNode next = curr.next; 
            curr.next = tmp; 
            tmp = curr;
            curr = next;  
        }
        return tmp; 
    }
}
