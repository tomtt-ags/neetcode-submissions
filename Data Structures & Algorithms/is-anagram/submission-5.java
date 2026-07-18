class Solution {
    public boolean isAnagram(String s, String t) {
        boolean flag = true;
        if(s.length() != t.length()){
            return false; 
        }
        HashMap<Character, Integer> seen = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); 
            seen.put(c, seen.getOrDefault(c, 0)+1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i); 
            if(!seen.containsKey(c)){
                flag = false;
                return flag; 
            }
            seen.put(c, seen.get(c)-1); 
            if(seen.get(c)<0){
                flag = false; 
                return flag; 
            }
        }
        return flag; 
    }
}
