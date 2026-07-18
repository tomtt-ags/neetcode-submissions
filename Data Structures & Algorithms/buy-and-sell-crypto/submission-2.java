class Solution {
    public int maxProfit(int[] prices) {
        //you want to sell before stock drops
        //keep if stock increases.
        int profit = 0; 
        int cur = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < cur){
                cur = prices[i]; 
            }
            profit = Math.max(profit, prices[i]-cur); 
        }
        return profit; 
    }
}
