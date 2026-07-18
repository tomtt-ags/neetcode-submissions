class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> out = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();  
        dfs(candidates, target, out, curr, 0); 
        return out; 
    }
    public void dfs(int[] nums, int target, List<List<Integer>> out,
    ArrayList<Integer> curr, int i){
        if(target == 0){
            out.add(new ArrayList<>(curr)); 
            return; 
        }
        if(target < 0 || i >= nums.length){
            return; 
        }
        target -= nums[i]; 
        curr.add(nums[i]); 
        dfs(nums, target, out, curr, i+1); 
        target += nums[i]; 
        curr.remove(curr.size()-1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++; 
        }
        dfs(nums, target, out, curr, i+1); 
    }
}
