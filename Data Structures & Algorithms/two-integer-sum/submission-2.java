class Solution {
    public int[] twoSum(int[] nums, int target) {
        //loop doing target - arr[i], if complement is present in
        //hashtable put arr[i] as 2nd element, find complement 
        //put index of it as first element 
        int[] out = new int[2];
        int complement = 0; 
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            complement = target - nums[i];
            if(set.contains(complement)){
                out[1] = i;
                break; 
            }
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==complement){
                out[0] = i; 
                break;
            }
        }
        return out;  
    }
}
