class Solution {
    public int search(int[] nums, int target) {
        //several cases, case mid == target return mid
        //case target is in range between mid and l, reduce r
        //to mid - 1
        //case target is greater than mid or less than l move l to 
        //mid + 1. 
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {

            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums [r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }

        return -1;
    }
}
