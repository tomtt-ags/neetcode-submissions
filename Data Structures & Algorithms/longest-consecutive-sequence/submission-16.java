class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0; 
        HashMap<Integer, Boolean> mp = new HashMap<>();
        HashMap<Integer, Integer> mp2 = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i], false);
            mp2.put(nums[i], 1);  
        }
        int res = 1;
        for(Map.Entry<Integer, Boolean> m : mp.entrySet()){
            int curr = m.getKey();
            int out = 1; 
            int n = mp.size(); 
            while(n > 0){
                if(mp.containsKey(curr-1)){
                    if(mp.get(curr-1) == true){
                        out += mp2.get(curr-1); 
                        break; 
                    } else {
                        out += 1; 
                        curr--; 
                        n--; 
                    }
                } else {
                    break; 
                }
            }
            mp2.put(m.getKey(), out); 
            mp.put(m.getKey(), true); 
            res = Math.max(res, out); 
        }
        return res; 
    }
}
