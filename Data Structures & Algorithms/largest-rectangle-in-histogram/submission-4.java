class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        //precompute left and right boundaries
        //right boundaries, loop from left to right
        //put the index onto the stack of all extendable ones, then 
        //when you run into a smaller column preventing extendability
        //push off all effected and set their index to -1 of the index
        //of the smaller column. 
        //calc area by doing ((right[i] - left[i]) + 1)*height[i]. 
        //take the max. 
        int[] Lbound = new int[heights.length]; 
        int[] Rbound = new int[heights.length]; 
        for(int i = 0; i < heights.length; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                Rbound[st.peek()] = i-1; 
                st.pop(); 
            }
            st.push(i); 
        }
        while(!st.isEmpty()) {
            Rbound[st.peek()] = heights.length-1; 
            st.pop(); 
        }

        for(int i = heights.length-1; i >= 0; i--) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                Lbound[st.peek()] = i+1; 
                st.pop(); 
            }
            st.push(i); 
        }
        while(!st.isEmpty()) {
            Lbound[st.peek()] = 0;
            st.pop(); 
        }
        int area = Integer.MIN_VALUE; 
        for(int i = 0; i < heights.length; i++) {
            int curr = ((Rbound[i] - Lbound[i]) + 1)*heights[i]; 
            area = Math.max(area, curr); 
        }
        return area; 
    }
}
