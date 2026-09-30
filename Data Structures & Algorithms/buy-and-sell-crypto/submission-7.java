class Solution {
    public int maxProfit(int[] prices) {
        int out = Integer.MIN_VALUE; 
        int l = 0;  
        for (int r = 0; r < prices.length; r++) {
            int curr = prices[r] - prices[l]; 
            out = Math.max(curr, out); 
            if(curr <= 0) {
                l = r; 
            }
        }
        return out; 
    }
}
