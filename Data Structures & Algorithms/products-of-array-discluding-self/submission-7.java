class Solution {
    public int[] productExceptSelf(int[] nums) {
        //calc prefix product of each element 
        //then multiply each prefix by its suffix which you can calc by just
        //iterating down your nums array. 
        int[] prefix = new int[nums.length]; 
        int pref = 1; 
        prefix[0] = pref; 
        for(int i = 1; i < nums.length; i++)
        {
            pref = pref * nums[i-1];
            prefix[i] = pref; 
        }
        int suffix = 1; 
        for(int i = nums.length-1; i > 0; i--)
        {
            prefix[i] = prefix[i]*suffix; 
            suffix = suffix * nums[i]; 
        }
        prefix[0] = suffix; 
        return prefix; 
    }
}  
