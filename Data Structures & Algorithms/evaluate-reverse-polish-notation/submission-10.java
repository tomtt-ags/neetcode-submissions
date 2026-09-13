class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") && !st.isEmpty()) {
                int b = st.pop();
                int a = st.pop(); 
                st.push(a+b);  
            } else if(tokens[i].equals("-") && !st.isEmpty()) {
                int b = st.pop();
                int a = st.pop();
                st.push(a-b); 
            } else if(tokens[i].equals("*") && !st.isEmpty()) {
                int b = st.pop();
                int a = st.pop();
                st.push(a*b);
            } else if(tokens[i].equals("/") && !st.isEmpty()) {
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
            } else {
                st.push(Integer.parseInt(tokens[i])); 
            }
        }
        if(!st.isEmpty()) return st.pop(); 
        return -1; 
    }
}
