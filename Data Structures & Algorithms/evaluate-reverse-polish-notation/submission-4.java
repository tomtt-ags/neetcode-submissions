class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>(); 
        int out = 0;
        int a = 0; 
        int b = 0;
        if(tokens.length == 1){
            out = Integer.parseInt(tokens[0]); 
            return out; 
        }
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                a = Integer.parseInt(st.pop()); 
                b = Integer.parseInt(st.pop()); 
                out = a + b; 
                st.push(Integer.toString(out)); 
                //continue; 
            } else if(tokens[i].equals("-")){
                a = Integer.parseInt(st.pop());
                b = Integer.parseInt(st.pop());
                out = b - a; 
                st.push(Integer.toString(out)); 
                //continue; 
            } else if(tokens[i].equals("*")){
                a = Integer.parseInt(st.pop());
                b = Integer.parseInt(st.pop());
                out = a * b; 
                st.push(Integer.toString(out)); 
                //continue; 
            } else if(tokens[i].equals("/")){
                a = Integer.parseInt(st.pop()); 
                b = Integer.parseInt(st.pop());
                out = b / a; 
                st.push(Integer.toString(out)); 
                //continue; 
            } else {
                st.push(tokens[i]); 
            }
        }
        return out; 
    }
}
