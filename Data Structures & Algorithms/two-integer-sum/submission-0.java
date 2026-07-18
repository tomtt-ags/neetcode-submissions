class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(nums[i] + nums[j] == target){
                    if(i < j){
                        output[0] = i;
                        output[1] = j;
                    }  else if(i > j){
                        output[0] = j;
                        output[1] = i;
                    }
                }
            }
        }
        return output; 
    }
}
