class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        //you gotta use a hashmap on each window, on each window
        //do the length of window - most common character if your
        //k replacements can cover it thats a valid window. 
        //otherwise you gotta shrink your window
        //tip: use a separate method to find the no. of most common
        //character in a window as on each shrinkage you need to compute 
        //it.
        int res = 0; 
        int l = 0; 
        for(int r = 0; r < s.length(); r++){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0)+1); 
            while((r-l+1) - mostFreq(mp)>k){
                mp.put(s.charAt(l), mp.get(s.charAt(l))-1); 
                l++; 
            }
            res = Math.max(res, r-l+1); 
        }
        return res; 
    }
    public int mostFreq(HashMap<Character, Integer> mp){
        int out = 0; 
        for(Map.Entry<Character, Integer> e : mp.entrySet()){
            if(e.getValue()>out){
                out = e.getValue(); 
            }
        }
        return out; 
    }
}
