class Solution {
    public int search(int[] nums, int target) {
        //several cases, case mid == target return mid
        //case target is in range between mid and l, reduce r
        //to mid - 1
        //case target is greater than mid or less than l move l to 
        //mid + 1. 
        int l = 0; 
        int r = nums.length-1; 
        while(l<=r) {
            int mid = l + (r-l)/2; 
            if(target == nums[mid]) {
                return mid; 
            } else if (target >= nums[l] && target < nums[mid]) {
                r = mid - 1; 
            } else if (target >= nums[l] && nums[mid] < nums[l]) {
                r = mid - 1; 
            } else if (target < nums[mid] && nums[mid] < nums[l]) {
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return -1; 
    }
}
