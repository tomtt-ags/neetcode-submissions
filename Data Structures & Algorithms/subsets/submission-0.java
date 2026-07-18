class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>(); 
        ArrayList<Integer> currSet = new ArrayList<>(); 
        int i = 0; 
        dfs(out, currSet, nums, i); 
        return out; 
    }
    public void dfs(List<List<Integer>> out, ArrayList<Integer> currSet, int[] nums, int i){
        if(i == nums.length){
            out.add(new ArrayList<>(currSet)); 
            return; 
        }
        currSet.add(nums[i]); 
        dfs(out, currSet, nums, i+1); 
        currSet.remove(currSet.size()-1); 
        dfs(out, currSet, nums, i+1); 
    }
}
