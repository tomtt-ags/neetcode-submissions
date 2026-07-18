class Solution {
    public int maxProfit(int[] prices) {
        //you want to sell before stock drops
        //keep if stock increases.
        int profit = 0; 
        int l = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < prices[l]){
                l = i; 
            }
            profit = Math.max(profit, prices[i]-prices[l]); 
        }
        return profit; 
    }
}
