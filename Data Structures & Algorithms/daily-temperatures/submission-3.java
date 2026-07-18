class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //im gona optimise this later, you want to push your first elements index onto stack
        //then loop through array, if its smaller than st.peek() then push it on, if its
        //bigger then resolve, so loop through your stack and while the current element
        //bigger then calc index of curr - index that at top of stack and put it into 
        //index in output array that corresponds
        //push current element to stack after. 
        Stack<Integer> st = new Stack<>(); 
        int[] res = new int[temperatures.length]; 
        st.push(0); 
        for(int i = 1; i < temperatures.length; i++){
            if(temperatures[i] <= temperatures[st.peek()]){
                st.push(i);
                continue; 
            }
            while(!st.isEmpty()){
                if(temperatures[i] > temperatures[st.peek()]){
                    res[st.peek()] = i - st.peek(); 
                    st.pop(); 
                }else{
                    break; 
                }
            }
            st.push(i); 
        }
        return res; 
    }
}
