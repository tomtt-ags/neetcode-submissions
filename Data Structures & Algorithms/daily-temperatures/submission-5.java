class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //each element of array will be difference between 
        //curr index and index of the warmer day
        //if no day is warmer then it will be 0. 
        //brute force nested loop so for each element loop till 
        //you get warmer element. 
        //push an element to the stack keep pushing till you find element 
        //bigger than the top of the stack
        //keep pushing while element is smaller than top of stack 
        //if an element is bigger then loop until top of stack is bigger 
        // as you pop elements off the stack put the difference at index
        //of top of stack. 
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
