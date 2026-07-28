class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        int[] out = new int[2]; 
        for(int i = 0; i < nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                out[0] = mp.get(target-nums[i]); 
                out[1] = i; 
                return out; 
            } else{
                mp.put(nums[i], i); 
            }
        }
        return out; 
    }
}
