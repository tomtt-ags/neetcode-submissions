class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0; 
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i]; 
            }
        }
        int l = 1; 
        int r = max; 
        int ans = max;
        while(l <= r) {
            int mid = l + (r - l) / 2; 
            long hrs = noOfHours(piles, mid); 
            if(hrs <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1; 
            }
        }
        return ans; 
    }
    public long noOfHours(int[] piles, int k) {
        long hrs = 0; 
        for(int i = 0; i < piles.length; i++) {
            hrs += (piles[i] + (long)k - 1) / k;
        }
        return hrs; 
    }
}