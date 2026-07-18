class Solution {
    public boolean hasDuplicate(int[] nums) {
      int n = nums.length; 
      int i = 0;
      
      while(i < n){
        int count = 0; 
       for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        if(count > 1){
            return true; 
        }
        i++; 
      }
      return false;
    }
}