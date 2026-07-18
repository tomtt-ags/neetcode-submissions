class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\s+", ""); 
        s = s.toLowerCase(); 
        s = s.replaceAll("\\p{Punct}", ""); 
        //literally have two pointers on either side of our word
        //have a while loop that runs while left pointer greater
        //than right and compares if the letters are equal. 
        //if we encounter false in this loop return false
        //if we leave it return true. 
        int l = 0; 
        int r = s.length()-1; 
        while (l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; 
            r--; 
        }
        return true; 
    }
}
