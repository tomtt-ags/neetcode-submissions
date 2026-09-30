class Solution {
    public int maxProfit(int[] prices) {
        //you want to buy low and sell high 
        //therefore you want to find the window in which 
        //this value is highest, right pointer always moves as
        //that is future, therefore you sell on right pointer. 
        //you want your left pointer to be on the smallest value
        //you come across, and right pointer to be on the highest. 
        //if you see the profit increasing keep making the window
        //bigger otherwise move the left pointer to where you lost
        //money
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
