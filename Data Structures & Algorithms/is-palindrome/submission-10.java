class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length()-1;
        // String p = preProcess(s); 
        // int end = p.length() - 1; 
        while(start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start)))   
                {
                    start++;
                }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) 
                {
                    end--;
                }
            if(Character.toLowerCase(s.charAt(start)) != 
            Character.toLowerCase(s.charAt(end))) {
                return false; 
            }
            start++;
            end--; 
        }
        return true;
    }
    // public String preProcess(String s) {
    //     String out = s.toLowerCase()
    //     .replaceAll(" ", "")
    //     .replaceAll("\\p{Punct}", ""); 
    //     return out; 
    // }
}
