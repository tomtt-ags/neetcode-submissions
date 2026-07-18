class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>(); 
        dfs(nums, target, 0, out, curr); 
        return out; 
    }
    public void dfs(int[] nums, int target, int i,
     List<List<Integer>>out, ArrayList<Integer> curr){
        if(target == 0){
            out.add(new ArrayList<>(curr)); 
            return; 
        }
        if(target < 0 || i >= nums.length){
            return; 
        }
        target -= nums[i]; 
        curr.add(nums[i]); 
        dfs(nums, target, i, out, curr); 
        target += nums[i]; 
        curr.remove(curr.size()-1); 
        dfs(nums, target, i+1, out, curr); 
    }
}
