class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> st = new ArrayDeque<>(); 
        st.push(0); 
        int[] out = new int[temperatures.length]; 
        for(int i = 1; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                out[st.peek()] = i - st.pop(); 
            }
            st.push(i); 
        }
        while(!st.isEmpty()){
            out[st.pop()] = 0; 
        }
        return out; 
    }
}
