class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int left = 0;
        int validLength = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            // shrink window until it's valid
            while (true) {
                int length = r - left + 1;
                int maxFreq = great(mp);
                if (length - maxFreq <= k) {
                    break;
                }

                char lc = s.charAt(left);
                mp.put(lc, mp.get(lc) - 1);
                left++;
            }

            // window [left, r] is valid here
            validLength = Math.max(validLength, r - left + 1);
        }

        return validLength;
    }

    private int great(HashMap<Character, Integer> mp) {
        int out = 0;
        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            out = Math.max(out, e.getValue());
        }
        return out;
    }
}
