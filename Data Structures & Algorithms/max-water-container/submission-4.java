class Solution {
    public int maxArea(int[] heights) {
         int l = 0; 
         int r = heights.length-1;
         int maxArea = Integer.MIN_VALUE; 
         while(l < r){
            int a = Math.min(heights[l], heights[r]); 
            int area = (r-l)*a; 
            if(a == heights[l]){
                l++; 
            } else {
                r--; 
            }
            maxArea = Math.max(maxArea, area); 
         }
         return maxArea; 
    }
}
