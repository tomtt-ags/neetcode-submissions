class Solution {
    public int maxArea(int[] heights) {
        //take two pointers, calc area, store it in variable
        //move teh smaller col, recalc and continue through
        //return biggest value. 
        int area = 0; 
        int l = 0; 
        int r = heights.length-1; 
        while(l < r) {
            int width = r - l; 
            int height = Math.min(heights[r], heights[l]); 
            area = Math.max(area, width*height); 
            if(height == heights[r]){
                r--; 
            } else {
                l++; 
            }
        }
        return area; 
    }
}
