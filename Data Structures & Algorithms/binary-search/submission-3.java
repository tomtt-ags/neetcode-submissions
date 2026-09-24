class Solution {
    public int search(int[] nums, int target) {
        int l = 0; 
        int r = nums.length-1; 
        while (l <= r) {
            if(target == nums[l]) {
                return l; 
            } else if(target == nums[r]) {
                return r; 
            } else {
                l++; 
                r--; 
            }
        }
        return -1;  
    }
}
