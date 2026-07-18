class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>(); 
        int[] res = new int[temperatures.length]; 
        st.push(0); 
        for(int i = 1; i < temperatures.length; i++){
            if(temperatures[i]<=temperatures[st.peek()]){
                st.push(i); 
            } else {
                while(!st.isEmpty()){
                    if(temperatures[i]>temperatures[st.peek()]){
                        res[st.peek()] = i - st.peek(); 
                        st.pop(); 
                    } else {
                        break; 
                    }
                }
                st.push(i); 
            }
        }
        return res; 
    }
}
