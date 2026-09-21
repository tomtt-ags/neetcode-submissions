class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //add indexes to stack, moment value is bigger than 
        //value in stack empty the stack and add the difference to 
        //that index of stack. 
        int[] out = new int[temperatures.length]; 
        Deque<Integer> st = new ArrayDeque<>();  
        for(int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && 
            temperatures[i] > temperatures[st.peek()]) {
                out[st.peek()] = i - st.peek(); 
                st.pop();
            }
            st.push(i);

        }
        while(!st.isEmpty()) {
            int i = st.pop(); 
            out[i] = 0; 
        }
        return out;
    }
}
