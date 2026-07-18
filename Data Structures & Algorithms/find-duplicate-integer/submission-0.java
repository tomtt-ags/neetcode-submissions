class Solution {
    public int findDuplicate(int[] nums) {
        //its a linked list problem where i want to find the first 
        //element of loop of linked list
        //the value at index of nums is index we want to go next
        int head = nums[0]; 
        int slow = head; 
        int fast = head; 
        int n = nums.length; 
        while(fast < n){
            fast = nums[nums[fast]]; 
            slow = nums[slow]; 
            if(fast == slow)break; 
        }
        int slow2 = head; 
        while(slow2 != slow){
            slow = nums[slow]; 
            slow2 = nums[slow2]; 
        }
        return slow; 
    }
}
