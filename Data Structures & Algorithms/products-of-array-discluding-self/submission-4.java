class Solution {
    public int[] productExceptSelf(int[] nums) {
        //on each iteration divide by current value, multiply by the value
        //before
        int[] out = new int[nums.length]; 
        int start = 1;
        int count = 0; 
        int temp = 1; 
        for(int i = 0; i < nums.length; i++){
            start *= nums[i]; 
            if(nums[i] == 0) count++; 
        }
        if(count == 1){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0) continue; 
                temp *= nums[i]; 
            }
        }
        int prev = -1; 
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                if(nums[i] == 0 && count == 1){
                    out[i] = temp; 
                    prev++; 
                    continue; 
                }
                if(nums[i] == 0){
                    out[i] = start; 
                    prev++;
                    continue; 
                }
                start = start / nums[i];
                prev++; 
                out[i] = start; 
                continue;  
            }
            if(nums[i] == 0 && count == 1){
                out[i] = temp; 
                prev++; 
                continue; 
            }
            if(nums[i] == 0){
              start = start * nums[prev]; 
              prev++; 
              out[i] = start; 
              continue;   
            }
            start = start/nums[i]; 
            start = start * nums[prev]; 
            prev++; 
            out[i] = start; 
        }
        return out; 
    }
}  
