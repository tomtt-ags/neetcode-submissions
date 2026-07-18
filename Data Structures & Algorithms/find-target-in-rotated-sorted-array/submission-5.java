class Solution {
    public int search(int[] nums, int target) {
       int right = nums.length-1;  
       int left = 0; 
       while(left <= right){
        int mid = (left + right)/2; 
        //System.out.println(nums[mid]); 
        if(target < nums[mid] && target < nums[left] && nums[mid] < nums[right]){
            right = mid - 1; 
        } else if(target < nums[mid] && target < nums[left]){
            left = mid + 1; 
        } else if(target < nums[mid] && target >= nums[left]){
            right = mid-1; 
        } else if(target > nums[mid] && nums[mid] > nums[right]){
            left = mid + 1;  
        } else if(target > nums[mid] && target <= nums[right]){
            left = mid + 1;  
        } else if(target > nums[mid]){
            right = mid - 1;  
        } else if(target == nums[mid]){
            return mid; 
        }
       }
       return -1; 
    }
}
