class Solution {
    public boolean isAnagram(String s, String t) {
        //add letters of one word to a hashmap, then add 2nd word to 
        //same hashmap, if anyword has a count of 1 in hashmap they 
        //not the same.
        if(s.length()!=t.length()) return false; 
        HashMap<Character, Integer> mp = new HashMap<>(); 
        for(int i = 0; i < s.length(); i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1); 
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)-1); 
        }
        for(Map.Entry<Character, Integer> m : mp.entrySet()){
            if(m.getValue()!=0) return false; 
        }
        return true; 
    }
}
