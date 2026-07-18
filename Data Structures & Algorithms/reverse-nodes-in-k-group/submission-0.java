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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 1; 
        ListNode temp = head;
        ListNode prev = null;
        ListNode start = head; 
        ListNode out = head;  
        while(temp != null){
            ListNode next = temp.next;  
            if(n % k == 0){
                ListNode end = temp;
                ListNode connect = reverse(start, end, prev);
                connect.next = next; 
                if (prev != null) {
                    prev.next = end;   
                } else {
                    out = end;         
                }
                prev = connect; 
                start = next;
            }
            n++; 
            temp = next; 
        }
        return out; 
    }
    public ListNode reverse(ListNode start, ListNode end, ListNode prev){
        ListNode stop = end.next;
        ListNode ret = start; 
        while(start != stop){
            ListNode next = start.next; 
            start.next = prev; 
            prev = start; 
            start = next; 
        }
        return ret;      
    }
}
