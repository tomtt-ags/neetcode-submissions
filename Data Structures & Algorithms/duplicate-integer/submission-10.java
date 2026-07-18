class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean flag = false; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1); 
        }
        for(int i : nums){
            if(map.get(i)>1){
                flag = true; 
            }
        }
        return flag; 
    }
}