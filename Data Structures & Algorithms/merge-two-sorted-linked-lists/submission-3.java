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
        ListNode currHead = null; 
        ListNode other = null; 
        if(list1 == null) return list2; 
        if(list2 == null) return list1; 
        if(list1.val <= list2.val){
            currHead = list1; 
            other = list2; 
        } else {
            currHead = list2; 
            other = list1; 
        }
        ListNode tempHead = currHead; 
        while(other != null && tempHead.next != null){
            if(other.val == tempHead.val || other.val >= tempHead.val && other.val <= tempHead.next.val){
                ListNode otherNext = other.next; 
                ListNode temp = tempHead.next; 
                tempHead.next = other; 
                tempHead = tempHead.next; 
                tempHead.next = temp; 
                other = otherNext; 
            } else {
                tempHead = tempHead.next;
            }
        }
        if(other != null){
            tempHead.next = other; 
        }
        return currHead; 
    }
}