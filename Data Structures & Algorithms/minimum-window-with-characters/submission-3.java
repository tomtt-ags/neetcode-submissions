class Solution {
    //for it to be the shortest possible substring both my left and 
    //right should be pointing to a letter of t 
    //a window is a substring that contains all letters 
    //so move the right pointer till we have all characters within that 
    //substring
    public String minWindow(String s, String t) {
        int l = 0;
        if(t.length() > s.length()) return "";
        String out = s; 
        for(int r = 0; r < s.length(); r++){
            while(l <= r && checkInclusion(t, s.substring(l, r+1))){
                if(out.length() > s.substring(l, r+1).length()){
                    out = s.substring(l, r+1); 
                }
                l++;
            }
        }
        if(!checkInclusion(t, out)) return ""; 
        return out; 
    }
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp = new HashMap<>(); 
        for(int i = 0; i < s1.length(); i++){
            mp.put(s1.charAt(i), mp.getOrDefault(s1.charAt(i), 0)+1); 
        }
        for(int i = 0; i < s2.length(); i++){
            if(mp.containsKey(s2.charAt(i))){
                mp.put(s2.charAt(i), mp.get(s2.charAt(i))-1); 
            }
        }
        for(Map.Entry<Character, Integer> e : mp.entrySet()){
            if(e.getValue() > 0) return false; 
        }
        return true; 
    }
}
