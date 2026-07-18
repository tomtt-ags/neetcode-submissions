class Solution {
    public boolean isPalindrome(String s) {
        //point to the left and right, compare if each character 
        //is the same and keep going while l < r
        int l = 0; 
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String filtered = sb.toString();
        int r = filtered.length()-1; 
        while(l <= r){
            if(filtered.charAt(l) == filtered.charAt(r)){
                l++; 
                r--; 
            } else {
                return false; 
            }
        }
        return true;
    }
}
