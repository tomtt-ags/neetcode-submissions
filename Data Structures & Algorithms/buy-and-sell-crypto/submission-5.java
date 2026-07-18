class Solution {
    public int maxProfit(int[] prices) {
        int b = 0; 
        int profit = 0; 
        for(int s = 1; s < prices.length; s++){
            if(prices[s] < prices[b]){
                b = s; 
            }
            profit = Math.max(profit, prices[s] - prices[b]); 
        }
        return profit; 
    }
}
