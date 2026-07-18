class Solution {
    public int lengthOfLongestSubstring(String s) {
        //find greatest window without repeats. 
        int l = 0; 
        if(s.length() == 0) return 0; 
        int out = Integer.MIN_VALUE; 
        HashSet<Character> set = new HashSet<>(); 
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l)); 
                l++; 
            }
            set.add(s.charAt(r)); 
            out = Math.max(out, r-l+1); 
        }
        return out; 
    }
}
