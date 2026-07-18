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
    public boolean hasCycle(ListNode head) {
        //check loop, fast pointer and slow pointer, if they equal each other
        //return true otherwise if fast gets to null return false. 
        ListNode fast = head; 
        ListNode slow = head; 
        while(fast != null && fast.next!=null){
            fast = fast.next.next; 
            slow = slow.next; 
            if(fast == slow) return true;
        }
        return false; 
    }
}
