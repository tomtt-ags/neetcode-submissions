class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] out = new int [k]; 
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1); 
        }
        ArrayList<Integer> temp = new ArrayList<>(mp.values()); 
        Collections.sort(temp); 
        
        int bound = temp.get(temp.size()-k);  
        int m = 0; 
        for(Map.Entry<Integer, Integer> p : mp.entrySet()){
            if(p.getValue() >= bound){
                out[m] = p.getKey(); 
                m++; 
            }
        }
        return out; 
    }
}
