class Solution {
    public int findMin(int[] nums) {
        int l = 0; 
        int r = nums.length-1;
        int mid = 0;  
        while(l < r){
            mid = (l+r)/2; 
            if(nums[l] < nums[r]){
                r = mid; 
            } else if(nums[mid] > nums[r]){
                l = mid + 1; 
            } else if(nums[mid] < nums[r]){
                if(mid > 0 && nums[mid-1] > nums[mid]){
                    return nums[mid]; 
                } else {
                    r = mid;
                }
            }
        }
        return nums[l]; 
    }
}