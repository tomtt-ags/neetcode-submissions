class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length(); 
        if((n%2) != 0) return false;
        HashMap<Character, Character> mp = new HashMap<>(); 
        mp.put('}', '{');
        mp.put(']', '['); 
        mp.put(')', '(');
        for (int i = 0; i < n; i++) {
            if(mp.containsValue(s.charAt(i))) {
                st.push(s.charAt(i)); 
            }
            else if(st.isEmpty()) {
            return false;
            } 
            else if(!st.isEmpty() && st.peek() == mp.get(s.charAt(i)))
            {
                st.pop();
            } else if (!st.isEmpty() && st.peek()!= mp.get(s.charAt(i))
            ) {
                return false; 
            }
        }
        if(!st.isEmpty()) return false; 
        return true; 
    }
}
