class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, int[]> mp = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++){
            if(mp.containsKey(nums[i])){
                mp.get(nums[i])[1]++; 
            } else {
                int[] bucket = new int[2]; 
                bucket[0] = nums[i]; 
                bucket[1] = 1; 
                mp.put(nums[i], bucket); 
            }
        }
        ArrayList<int[]> out = new ArrayList<>(mp.values()); 
        out.sort((a, b) -> a[1] - b[1]); 
        int startInd = out.size() - k;
        int[] outp = new int[k]; 
        for(int i = startInd; i < out.size(); i++){
            outp[i-startInd] = out.get(i)[0]; 
        }
        return outp; 
    }
}
