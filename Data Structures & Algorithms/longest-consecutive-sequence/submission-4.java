class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2){
            return nums.length; 
        }
        boolean flag = true;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                flag = false; 
            }
        } 
        if(flag){
            return 1; 
        }
        Arrays.sort(nums);
        int count = 1; 
        int res = 0; 
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue; 
            }
            if(nums[i] == nums[i+1]-1){
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res; 
    }
}
