class MinStack {
    ArrayList<Integer> st;
    ArrayList<Integer> min;
    int temp = Integer.MAX_VALUE;  
    public MinStack() {
        st = new ArrayList<>(); 
        min = new ArrayList<>(); 
    }
    
    public void push(int val) {
        st.add(val); 
        if(val <= temp){
            temp = val;
            min.add(temp); 
        } 
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            int top = st.get(st.size() - 1);

            // FIXED PART: update min correctly based on the top element and keep temp in sync
            if (!min.isEmpty() && top == min.get(min.size() - 1)) {
                min.remove(min.size() - 1);
                if (min.isEmpty()) {
                    temp = Integer.MAX_VALUE;
                } else {
                    temp = min.get(min.size() - 1);
                }
            }
            st.remove(st.size() - 1);
        }  
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.get(st.size()-1);
        } 
        return -1; 
    }
    
    public int getMin() {
        if(!min.isEmpty() && min.size() > 0) {
            return min.get(min.size()-1); 
        }
        return -1; 
    }
}
