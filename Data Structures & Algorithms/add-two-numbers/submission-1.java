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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carr = 0; 
        ListNode dummy = new ListNode(-1); 
        ListNode temp = dummy; 
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carr; 
            int val = sum % 10; 
            temp.next = new ListNode(val); 
            temp = temp.next; 
            if(sum > 9){
                carr = 1;
            } else {
                carr = 0; 
            }
            if(l1.next == null && l2.next == null){
                if(carr > 0){
                    temp.next = new ListNode(carr);
                    temp = temp.next; 
                    return dummy.next;  
                } else {
                    return dummy.next;
                }
            }
            l1=l1.next; 
            l2=l2.next;
        }
        if(l1 == null && l2!=null){
            while(l2!=null){
                int sum2 = l2.val + carr; 
                int val2 = sum2 % 10; 
                temp.next = new ListNode(val2); 
                temp = temp.next; 
                if(sum2 > 9){
                    carr = 1; 
                } else {
                    carr = 0; 
                }
                l2 = l2.next; 
            }
            if(carr > 0){
                temp.next = new ListNode(carr); 
            }
        }
        if(l1 != null && l2==null){
            while(l1!=null){
                int sum3 = l1.val + carr; 
                int val3 = sum3 % 10; 
                temp.next = new ListNode(val3); 
                temp = temp.next; 
                if(sum3 > 9){
                    carr = 1; 
                } else {
                    carr = 0; 
                }
                l1 = l1.next; 
            }
            if(carr > 0){
                temp.next = new ListNode(carr); 
            }
        }
        return dummy.next; 
    }
}
