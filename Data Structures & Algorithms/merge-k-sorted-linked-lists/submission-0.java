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
    public ListNode mergeKLists(ListNode[] lists) {
        // have method that merges two sorted lists, 
        //loop through array lists and keep passing in your sorted list
        //and next element.
        if(lists.length < 1) return null; 
        ListNode sorted = lists[0]; 
        for(int i = 1; i < lists.length; i++){
            sorted = mergeTwo(sorted, lists[i]); 
        }
        return sorted; 
    }
    public ListNode mergeTwo(ListNode sorted, ListNode n2){
        ListNode dummy = new ListNode(0); 
        ListNode node = dummy;
        while (sorted != null && n2 != null) {
            if (sorted.val < n2.val) {
                node.next = sorted;
                sorted = sorted.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }

        if (sorted != null) {
            node.next = sorted;
        } else {
            node.next = n2;
        }

        return dummy.next;
    }
}
