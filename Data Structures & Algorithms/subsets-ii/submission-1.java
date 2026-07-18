class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> out = new ArrayList<>(); 
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>(); 
        dfs(nums, 0, out, curr); 
        return out; 
    }
    public void dfs(int[] nums, int i, 
    List<List<Integer>> out, List<Integer> curr){
        if(i >= nums.length){
            ArrayList<Integer> res = new ArrayList<>(curr); 
            out.add(res); 
            return; 
        }
        curr.add(nums[i]); 
        dfs(nums, i+1, out, curr); 
        curr.remove(curr.size()-1); 
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++; 
        }
        dfs(nums, i+1, out, curr); 
    }
}
