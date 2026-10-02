class Solution {
    public int characterReplacement(String s, int k) {
        //you want to use a hashmap to keep track of counts of 
        //every character in a substring, take the highest count 
        //element if len(substring) - count <= k then curr = len
        //otherwise
        int l = 0; 
        int out = 0;
        HashMap<Character, Integer> mp = new HashMap<>(); 
        for(int r = 0; r < s.length(); r++) {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            int curr = (r-l+1)-maxCount(mp);
            while(curr > k && l <= r) {
                mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l), 0)
                 - 1);
                l++; 
                curr = (r-l+1)-maxCount(mp);
            } 
            if(curr <= k) {
                out = Math.max(out, (r-l+1)); 
            }
        }
        return out; 
    }
    public Integer maxCount(HashMap<Character, Integer> mp) {
        int out = Integer.MIN_VALUE; 
        for (Map.Entry<Character, Integer> p : mp.entrySet()) {
            if(p.getValue() > out){
                out = p.getValue(); 
            }
        }
        return out;      
    }
}
