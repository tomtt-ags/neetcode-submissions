class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //mininum is the number closest to h. Slowest we can 
        //eat our bananas in the time. 
        //relate to binary search. 
        int r = Integer.MIN_VALUE; 
        int l = 1; 
        for(int i = 0; i < piles.length; i++){
            if(piles[i]>r){
                r = piles[i]; 
            }
        }
        int res = Integer.MAX_VALUE; 
        while(l<=r){
            int mid = (l+r)/2; 
            int check = checkRate(mid, piles);
            if(check <= h){
                res = mid; 
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return res; 
    }
    public int checkRate(int rate, int[] piles){
        int hours = 0; 
        for(int i = 0; i < piles.length; i++){
            hours += piles[i]/rate; 
            if(piles[i] % rate > 0){
                hours += 1; 
            }
        }
        return hours; 
    }
}
