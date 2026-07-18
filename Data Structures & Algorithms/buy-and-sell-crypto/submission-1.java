class Solution {
    public int maxProfit(int[] prices) {
        int currStock = prices[0]; 
        int sum = 0; 
        int outp = 0; 
        for(int i = 1; i < prices.length; i++){
            if(prices[i]>=currStock){
                outp = prices[i] - currStock; 
                sum = Math.max(sum, outp); 
            } else if (currStock > prices[i]){
                currStock = prices[i]; 
            }
        }
        return sum; 
    }
}
