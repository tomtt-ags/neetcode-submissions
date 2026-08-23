class Solution {
    public int longestConsecutive(int[] nums) {
        //i need to keep track of counts 
        HashSet<Integer> set = new HashSet<>(); 
        for(int num : nums) {
            set.add(num); 
        }
        int out = 0; 
        for(int num : set) {
            if(set.contains(num-1)) continue;
            //identify start point
            int count = 1;  
            int curr = num; 
            while(set.contains(curr+1)) {
                //iterate from start point
                count++; 
                curr++; 
            }
            //update to get which start point prod highest count
            out = Math.max(out, count); 
        }
        return out; 
    }
}
