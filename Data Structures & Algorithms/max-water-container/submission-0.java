class Solution {
    public int maxArea(int[] heights) {
        int start = 0; 
        int end = heights.length - 1;
        int area = Integer.MIN_VALUE;  
        while(start < end){
            int width = end - start; 
            int height = Math.min(heights[start], heights[end]); 
            int temp = height * width; 
            area = Math.max(area, temp); 
            if(heights[start]<=heights[end]){
                start++;  
            } else if(heights[end] <= heights[start]){
                end--; 
            }
        }
        return area; 
    }
}
