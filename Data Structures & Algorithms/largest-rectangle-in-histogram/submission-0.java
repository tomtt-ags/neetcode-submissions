class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; 
        Stack<int[]> st = new Stack<>(); 
        st.push(new int[]{0, heights[0]}); 
        for(int i = 1; i < heights.length; i++){
            int temp = i;
            while(!st.isEmpty() && st.peek()[1]>heights[i]){               
                    int area = st.peek()[1] * (i - st.peek()[0]);
                    maxArea = Math.max(maxArea, area); 
                    temp = st.peek()[0]; 
                    st.pop();              
            }
        st.push(new int[]{temp, heights[i]}); 
        }
        while(!st.isEmpty()){
            int[] top = st.pop(); 
            int idx = top[0]; 
            int h = top[1]; 
            int area = h*(heights.length-idx); 
            maxArea = Math.max(area, maxArea); 
        }
        return maxArea; 
    }
}
