class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "");
        clean = clean.toLowerCase(); 
        int left = 0; 
        int right = clean.length()-1;
        while(left < right){
            if(clean.charAt(left) != clean.charAt(right)){
                return false;
            } else {
                left++; 
                right--; 
            }
        }
        return true; 
    }
}
