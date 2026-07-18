class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> out = new ArrayList<>(); 
        TreeMap<Integer, Integer> check = new TreeMap<>(); 
        for(int i = 0; i < k; i++){
            check.put(nums[i], check.getOrDefault(nums[i], 0)+1);
        }
        out.add(check.lastKey()); 
        int l = 0; 
        for(int r = k; r < nums.length; r++){
            check.put(nums[r], check.getOrDefault(nums[r], 0)+1);
            check.put(nums[l], check.get(nums[l])-1);
            if(check.get(nums[l])==0){
                check.remove(nums[l]);
            }
            l++;
            out.add(check.lastKey());  
        }
        int[] output = new int[out.size()]; 
        for(int i = 0; i < out.size(); i++){
            output[i] = out.get(i); 
        }
        return output; 
    }
}
