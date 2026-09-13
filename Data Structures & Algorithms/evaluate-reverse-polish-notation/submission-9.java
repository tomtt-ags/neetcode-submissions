class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>(); 
        for(int i = 0; i < tokens.length; i++) {
            st.push(tokens[i]); 
        }
        return recurse(st);  
    }
    public int recurse (Stack<String> st) {
        // if(st.size() == 1) {
        //     String s = st.pop(); 
        //     return Integer.parseInt(s); 
        // }
        String n = st.pop(); 
        if(n.equals("-")) {
            int b = recurse(st);
            int a = recurse(st);
            return a - b; 
        } else if(n.equals("+")) {
            int b = recurse(st);
            int a = recurse(st);
            return a + b;
        } else if (n.equals("*")) {
            int b = recurse(st);
            int a = recurse(st);
            return a * b;
        } else if (n.equals("/")){
            int b = recurse(st);
            int a = recurse(st);
            return a / b;
        } else {
            return Integer.parseInt(n);
        }
    }
}
