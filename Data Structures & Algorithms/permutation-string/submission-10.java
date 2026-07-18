class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //you need to do a fixed window with the smaller string
        //then on each window you need a function that checks 
        //permutation
        //the check is the same as checking for anagrams. 
        int l = 0; 
        for(int r = s1.length(); r <= s2.length(); r++){
            System.out.println(s2.substring(l, r));
            if(checkPerm(s1, s2.substring(l, r))){
                return true; 
            }
            l++;
        }
        return false; 
    }
    public boolean checkPerm(String s1, String s2){
        StringBuilder sb1 = new StringBuilder(); 
        StringBuilder sb2 = new StringBuilder();
        int[] freq = new int[26]; 
        for (char c : s1.toCharArray()){
            freq[c - 'a']++; 
        }
        for (int i : freq){
            sb1.append(i).append('#'); 
        }
        String s = sb1.toString(); 
        int[] freq2 = new int[26]; 
        for (char c : s2.toCharArray()){
            freq2[c - 'a']++; 
        }
        for (int i : freq2){
            sb2.append(i).append('#'); 
        }
        String b = sb2.toString(); 
        if(s.equals(b)){
            return true; 
        } else {
            return false; 
        }
        
    }
}
