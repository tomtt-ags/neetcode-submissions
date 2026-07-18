class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //do a combination based solution where we put our valid answers
        //into a hashset then copy over the values of this hashset to our 
        //output. 
        HashSet<List<Integer>> set = new HashSet<>();
        ArrayList<Integer> curr = new ArrayList<>();  
        dfs(nums, target, set, curr); 
        List<List<Integer>> out = new ArrayList<>(set); 
        return out; 
    }
    public void dfs(int[] nums, int target, HashSet<List<Integer>> set
    , ArrayList<Integer> curr){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<>(curr);
            Collections.sort(temp); 
            set.add(new ArrayList<>(temp)); 
            return; 
        }
        if(target < 0) return; 
        for(int j = 0; j < nums.length; j++){
            target -= nums[j];
            curr.add(nums[j]);  
            dfs(nums, target, set, curr); 
            target += nums[j]; 
            curr.remove(curr.size()-1); 
        }
    }
}
