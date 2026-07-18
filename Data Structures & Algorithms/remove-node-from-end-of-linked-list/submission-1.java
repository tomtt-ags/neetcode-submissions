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
        if (head != null && head.next == null && n == 1) {
            return null;
        }
        int count = 0; 
        ListNode temp = head;
        //lets reverse the list first
        ListNode prev = null; 
        while(temp!=null){
            ListNode next = temp.next; 
            temp.next = prev; 
            prev = temp; 
            temp = next; 
        } 
        ListNode temp2 = prev; 
        while(temp2!=null){
            count++;
            if(n == 1){
                prev = prev.next; 
                break; 
            }
            if(n-1 == count){
                if(temp2.next == null){
                    temp2 = null; 
                    break; 
                }
                temp2.next = temp2.next.next; 
                break; 
            }
            temp2 = temp2.next; 
        }
        ListNode out = null; 
        while(prev!=null){
            ListNode next = prev.next; 
            prev.next = out; 
            out = prev; 
            prev = next; 
        }
        return out; 
    }
}
