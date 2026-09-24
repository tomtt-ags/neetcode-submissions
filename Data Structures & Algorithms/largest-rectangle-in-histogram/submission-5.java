class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<int[]> st = new ArrayDeque<>(); 
        int area = 0; 
        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]) {
                start = st.peek()[0]; 
                int curr = (i - st.peek()[0])*st.peek()[1]; 
                area = Math.max(area, curr); 
                st.pop(); 
            }
            st.push(new int[]{start, heights[i]}); 
        }
        while(!st.isEmpty()) {
            int finale = (heights.length - st.peek()[0])*st.peek()[1]; 
            area = Math.max(finale, area); 
            st.pop(); 
        }
        return area;  
    }
}