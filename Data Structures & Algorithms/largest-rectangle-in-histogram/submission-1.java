class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0; 
        Stack<int[]> st = new Stack<>(); 
        st.push(new int[]{0, heights[0]}); 
        for(int i = 1; i < heights.length; i++){
            int temp = i; 
            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                int area = st.peek()[1]*(i-st.peek()[0]); 
                temp = st.peek()[0]; 
                max = Math.max(max, area); 
                st.pop(); 
            }
            st.push(new int[]{temp, heights[i]}); 
        }
        while(!st.isEmpty()){
            int a = st.peek()[1] * (heights.length - st.peek()[0]); 
            max = Math.max(max, a); 
            st.pop(); 
        }
        return max; 
    }
}
