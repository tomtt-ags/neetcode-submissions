class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        String p = preProcess(s); 
        int end = p.length() - 1; 
        while(start < end) {
            if(p.charAt(start) != p.charAt(end)) {
                return false; 
            }
            start++;
            end--; 
        }
        return true;
    }
    public String preProcess(String s) {
        String out = s.toLowerCase()
        .replaceAll(" ", "")
        .replaceAll("\\p{Punct}", ""); 
        return out; 
    }
}
