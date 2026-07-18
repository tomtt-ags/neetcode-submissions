class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0; 
        int out = 1; 
        int temp = l; 
        if(s.length() == 0) return 0; 
        for(int r = 1; r < s.length(); r++){
            while(temp < r && s.charAt(temp) != s.charAt(r)){
                out = Math.max(temp - l + 1, out);
                temp++; 
            }
            if(temp == r){
                out = Math.max(temp - l + 1, out);
                temp = l; 
            } else if(temp < r){
                l = temp + 1;
                temp = l;  
            }
        }
        return out; 
    }
}
