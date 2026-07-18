class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0; 
        int r = 0;
        int length = Integer.MIN_VALUE; 
        HashSet<Character> set = new HashSet<>(); 
        for(int l = 0; l < s.length(); l++){
            while(r < s.length()){
                if(!set.contains(s.charAt(r))){
                    length = Math.max(length, r-l+1);
                    set.add(s.charAt(r)); 
                    r++;
                } else {
                    break; 
                }
            }
            set.remove(s.charAt(l)); 
        }
        return length; 
    }
}
