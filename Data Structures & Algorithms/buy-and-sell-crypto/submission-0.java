class Solution {
    public int maxProfit(int[] prices) {
        int currStock = prices[0]; 
        int out = 0; 
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > currStock){
                int diff = prices[i] - currStock; 
                out = Math.max(out, diff); 
            } else {
                currStock = prices[i]; 
            }
        }
        return out; 
    }
}
