class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>(); 
        //for the outer closed bracket it must be last to be closed 
        //ie stack builds up when you have multiple closed brackets. 
        //okay cool so if you see a closed bracket push it onto stack, 
        //if an open bracket corresponding to it exists remove it from stack 
        //if stack is empty by end then true else false. 
        if(s.length() % 2 == 1) return false; 
        int track = s.length()-1;
        st.push(s.charAt(track)); 
        track--; 
        while(!st.isEmpty() || track >= 0){
            if(track >= 0 && (s.charAt(track) == '}' || s.charAt(track) == ')' || s.charAt(track) == ']')){
                st.push(s.charAt(track)); 
                //track--;
            } else if(track >= 0 && (!st.isEmpty() && s.charAt(track) == '{' && st.peek() == '}')){
                st.pop();
            } else if(track >= 0 && (!st.isEmpty() && s.charAt(track) == '(' && st.peek() == ')')){
                st.pop();
            } else if(track >= 0 && (!st.isEmpty() && s.charAt(track) == '[' && st.peek() == ']')){
                st.pop(); 
            } else {
                return false; 
            }
            track--; 
            
        }
        System.out.println(track); 
        if(st.isEmpty()) return true; 
        return false; 
    }
}
