class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0]; 
        int left = 0; 
        int right = nums.length-1; 
        int out = 0; 
        while(left <= right){
            int mid = (left + right)/2; 
            if(mid == nums.length - 2 && left == mid && nums[mid] < nums[mid+1]) break; 
            if(nums[mid] > nums[left]){
                left = mid; 
            } else if(nums[mid] < nums[right]){
                right = mid; 
            } else if(mid+1 < nums.length && nums[mid+1] < nums[mid]){
                return nums[mid+1]; 
            }
        }
        return nums[0];
    }
}
