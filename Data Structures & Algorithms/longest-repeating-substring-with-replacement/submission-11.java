class Solution {
    public int characterReplacement(String s, int k) {
        // freq[c] = count of char 'A' + c in current window
        int[] freq = new int[26];
        
        int left = 0;
        int maxCountInWindow = 0; // max frequency of a single char in current window
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            
            // Update the max freq in the window
            maxCountInWindow = Math.max(maxCountInWindow, freq[idx]);
            
            // If more than k chars need to be replaced, shrink from the left
            while ((right - left + 1) - maxCountInWindow > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
