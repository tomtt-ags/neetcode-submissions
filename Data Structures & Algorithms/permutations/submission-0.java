class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, 0); 
    }
    public List<List<Integer>> dfs(int[] nums, int i){
        if(i == nums.length){
            List<List<Integer>> res = new ArrayList<>(); 
            res.add(new ArrayList<>()); 
            return res; 
        }
        List<List<Integer>> resPerms = new ArrayList<>(); 
        List<List<Integer>> perms = dfs(nums, i+1); 
        for(List<Integer> p : perms){
            for(int j = 0; j < p.size()+1; j++){
                List<Integer> pCopy = new ArrayList<>(p); 
                pCopy.add(j, nums[i]); 
                resPerms.add(pCopy); 
            }
        }
        return resPerms; 
    }
}
