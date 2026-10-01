class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>(); 
        int l = 0; 
        int out = 0; 
        for(int r = 0; r < s.length(); r++) {
            if(set.contains(s.charAt(r))) {
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;  
                }  
            }
            set.add(s.charAt(r)); 
            out = Math.max(out, r-l+1); 
        }
        return out; 
    }
}
