class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outp = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 
        int index = 0; 
        helper(index, nums, curr, outp); 
        return outp; 
    }
    public void helper(int i, int[] nums, List<Integer> curr,
    List<List<Integer>> outp) {
        if(i == nums.length) {
            outp.add(new ArrayList<>(curr)); 
            return; 
        }
        curr.add(nums[i]); 
        helper(i+1, nums, curr, outp); 
        curr.removeLast(); 
        helper(i+1, nums, curr, outp); 
    }
}
