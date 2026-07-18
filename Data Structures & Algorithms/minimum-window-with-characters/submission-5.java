class Solution {
    //for it to be the shortest possible substring both my left and 
    //right should be pointing to a letter of t 
    //a window is a substring that contains all letters 
    //so move the right pointer till we have all characters within that 
    //substring
    public String minWindow(String s, String t) {
        int l = 0;
        if(t.length() > s.length()) return "";
        HashMap<Character, Integer> tm = new HashMap<>();
        HashMap<Character, Integer> sm = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tm.put(t.charAt(i), tm.getOrDefault(t.charAt(i), 0)+1); 
            sm.put(t.charAt(i), 0);
        }
        String out = "";
        int res = Integer.MAX_VALUE;

        // need = number of distinct characters we must satisfy
        int need = tm.size();
        int req = 0;
        for(int r = 0; r < s.length(); r++){
            if(sm.containsKey(s.charAt(r))){
                sm.put(s.charAt(r), sm.get(s.charAt(r))+1);
                if(sm.get(s.charAt(r)) == tm.get(s.charAt(r))){
                    req++; 
                } 
            }
            while(req == need){
                if(res > r-l+1){
                    res = r-l+1; 
                    out = s.substring(l, r+1); 
                }
                if(sm.containsKey(s.charAt(l))){
                    sm.put(s.charAt(l), sm.get(s.charAt(l))-1);
                    if(sm.get(s.charAt(l))+1 == tm.get(s.charAt(l))){
                        req--;
                    }
                }
                l++;
            }
            
        }
        return out; 
    }
}
