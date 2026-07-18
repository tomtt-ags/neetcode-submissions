class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //i need a way to validate whether a rate k is greater than hours or less than hours
        Arrays.sort(piles); 
        int l = 1; 
        int r = piles[piles.length-1]; 
        int candidate = Integer.MAX_VALUE; 
        while(l<=r){
            int mid = (l+r)/2; 
            int count = 0; 
            for(int i = 0; i < piles.length; i++){
                count += piles[i]/mid; 
                if(piles[i]%mid>0){
                    count++; 
                }
            }
            //System.out.println(count); 
            if(count > h){
                l = mid+1; 
            } else if (count <= h){
                candidate = Math.min(mid, candidate); 
                r = mid - 1; 
            }
        }
        return candidate; 
    }
}
