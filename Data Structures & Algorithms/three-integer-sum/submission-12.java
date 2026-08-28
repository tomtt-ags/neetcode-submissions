class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort the array this is to avoid any duplicates
        //for each element we then just want to run 2sum via 
        //2 pointer method on the remaining sorted part of the array
        List<List<Integer>> out = new ArrayList<>();
        if(nums.length < 3) return out; 
        Arrays.sort(nums); 
        for(int i = 0; i < nums.length; i++) {
            int target = nums[i] * -1;
            int l = i+1; 
            int r = nums.length-1; 
            while(l < r) {
                int check = nums[l] + nums[r]; 
                if(check == target){
                    ArrayList<Integer> val = new ArrayList<>();
                    val.add(nums[i]); 
                    val.add(nums[l]); 
                    val.add(nums[r]); 
                    out.add(val);
                    l++; 
                    r--; 
                    while(l < r && nums[l] == nums[l-1]) {
                        l++; 
                    }
                    while(l < r && nums[r] == nums[r+1]) {
                        r--; 
                    }
                }
                if(check > target){
                    r--; 
                } else if(check < target){
                    l++; 
                } 
            }
            while(i + 1 < nums.length && nums[i] == nums[i+1]) {
                i++; 
            }
        }
        return out; 
    }
}
