class Solution {
    public int characterReplacement(String s, int k) {
    //     //you want to use a hashmap to keep track of counts of 
    //     //every character in a substring, take the highest count 
    //     //element if len(substring) - count <= k then curr = len
    //     //otherwise
    //     int l = 0; 
    //     int out = 0;
    //     HashMap<Character, Integer> mp = new HashMap<>(); 
    //     for(int r = 0; r < s.length(); r++) {
    //         mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
    //         int curr = (r-l+1)-maxCount(mp);
    //         while(curr > k && l <= r) {
    //             mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l), 0)
    //              - 1);
    //             l++; 
    //             curr = (r-l+1)-maxCount(mp);
    //         } 
    //         if(curr <= k) {
    //             out = Math.max(out, (r-l+1)); 
    //         }
    //     }
    //     return out; 
    // }
    // public Integer maxCount(HashMap<Character, Integer> mp) {
    //     int out = Integer.MIN_VALUE; 
    //     for (Map.Entry<Character, Integer> p : mp.entrySet()) {
    //         if(p.getValue() > out){
    //             out = p.getValue(); 
    //         }
    //     }
    //     return out;      
    // }
    //i want to do sliding window that increases size on each loop. The window only 
    //decreases once the length - max count of characters > k as too many replacements. 
    //i keep track of most freq characters ever seen and after validating window against k 
    //i store that length if k is valid. I will only change maxfreq if the current 
    //character has more than prev max freq as we only care to change our output if
    //we find a character with higher max freq in a valid window. we dont need to 
    //calc max freq every time windwo decreases like i did in prev solution as we only care
    //when max freq increases. 
    //the moment you find the highest no of characters and teh window decreases its 
    //as you have mazed out your output for taht higheset number of characters
    //so it doesnt matter if you then calc with that stale maxf as we have alr stored the 
    // max it can give us. 
    // "We've already got the maximum answer that this maxFreq can produce, so we don't 
    // need to decrease maxFreq."
        HashMap<Character, Integer> mp = new HashMap<>(); 
        int maxf = 0;
        int l = 0;
        int out = 0;   
        for(int r = 0; r < s.length(); r++) {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1); 
            maxf = Math.max(maxf, mp.get(s.charAt(r))); 
            while(((r-l) + 1) - maxf > k) {
                mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l), 0) - 1); 
                l++; 
            }
            out = Math.max(out, (r-l)+1); 
        }
        return out; 
    }
}
