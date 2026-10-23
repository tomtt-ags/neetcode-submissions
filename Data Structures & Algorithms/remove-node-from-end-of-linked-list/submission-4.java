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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0; 
        ListNode tmp = head; 
        while(tmp != null) {
            length++; 
            tmp = tmp.next; 
        }
        if(length < n) return head; 
        if(n == length){
            return head.next; 
        }
        //you remove a node by going to node before it and changing its next to the one
        //after it. SO we will go to length - (n-1)then change its next to .next.next. 
        int ind = 0; 
        tmp = head; 
        while(tmp.next != null) {
            if(ind == (length-n-1)) {
                tmp.next = tmp.next.next;
                break; 
            }
            tmp = tmp.next; 
            ind++; 
        }
        return head; 
    }
}
