class Solution {
    public boolean isPalindrome(String s) {
        String test = s;
        test = test.replaceAll("\\s+", ""); 
        test = test.toLowerCase(); 
        test = test.replaceAll("\\p{Punct}", ""); 
        System.out.println(test); 
        //literally have two pointers on either side of our word
        //have a while loop that runs while left pointer greater
        //than right and compares if the letters are equal. 
        //if we encounter false in this loop return false
        //if we leave it return true. 
        int l = 0; 
        int r = test.length()-1; 
        while (l<r){
            if(test.charAt(l) != test.charAt(r)) return false;
            System.out.println(test.charAt(l)); 
            System.out.println(test.charAt(r)); 
            l++; 
            r--; 
        }
        return true; 
    }
}
