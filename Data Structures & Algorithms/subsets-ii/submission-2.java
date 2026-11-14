class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> out = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 
        Arrays.sort(nums); 
        helper(0, nums, curr, out); 
        return out; 
    }
    public void helper(int i, int[] nums, List<Integer>
    curr, List<List<Integer>> out) {
        if(i == nums.length) {
            out.add(new ArrayList<>(curr)); 
            return; 
        }
        curr.add(nums[i]); 
        helper(i+1, nums, curr, out);
        curr.removeLast(); 
        while(i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++; 
        }
        helper(i+1, nums, curr, out); 
    }
}
