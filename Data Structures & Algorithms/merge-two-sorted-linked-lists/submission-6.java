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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null; 
        if(list1 == null && list2 != null) return list2; 
        if(list2 == null && list1 != null) return list1; 
        ListNode head = null; 
        ListNode other = null; 
        if(list1.val <= list2.val) {
            head = list1; 
            other = list2; 
        } else {
            head = list2; 
            other = list1; 
        }
        //ListNode curr = head.next; 
        ListNode p1 = head.next; 
        ListNode p2 = other; 
        ListNode tmp = head; 
        while(p1!=null && p2!=null) {
            if(p1.val < p2.val) {
                tmp.next = p1;
                tmp = tmp.next;  
                p1 = p1.next; 
            } else {
                tmp.next = p2; 
                tmp = tmp.next; 
                p2 = p2.next; 
            }
        }
        if(p1 == null && p2 != null) {
            tmp.next = p2; 
        }
        if(p2 == null && p1 != null) {
            tmp.next = p1; 
        }
        return head; 
    }
}