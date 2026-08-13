class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //create a hashmap with the key as the number, the value 
        //is the count of that number. 
        //collapse the hashmap into a collection, sort it
        //pick the final k elements. 
        HashMap<Integer, Pair> mp = new HashMap<>(); 
        for(int i =0; i < nums.length; i++){
            if(mp.containsKey(nums[i])){
                Pair val = mp.get(nums[i]); 
                val.set(val.y+1);
            } else {
                mp.put(nums[i], new Pair(nums[i], 1)); 
            }
        }
        ArrayList<Pair> check = new ArrayList<>(mp.values()); 
        check.sort(
            (a, b) -> Integer.compare(a.y, b.y)
        ); 
        int[] out = new int[k]; 
        int r = 0; 
        for(int i = check.size()-k; i < check.size(); i++){
            out[r] = check.get(i).x; 
            r++; 
        }
        return out; 
    }
    public class Pair
    {
        int x; 
        int y; 
        public Pair(int x, int y){
            this.x = x; 
            this.y = y; 
        }
        public void set(int n){
            this.y = n; 
        }
    }
}
