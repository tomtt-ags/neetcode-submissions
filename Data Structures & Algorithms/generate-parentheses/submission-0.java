class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>(); 
        List<String> curr = new ArrayList<>(); 
        String[] temp = new String[n*2];
        for(int i = 1; i < temp.length; i+=2){
            temp[i-1] = "("; 
            temp[i] = ")"; 
        }
        List<String> pre = dfs(temp, 0);
        curr = parCheck(pre);
        return curr;  
    }
    public List<String> parCheck(List<String>pre){
        List<String> valid = new ArrayList<>();
        for(int i = 0; i < pre.size(); i++){
            if(parent(pre.get(i))){
                valid.add(pre.get(i)); 
            }
        }
        return valid; 
    }
    public boolean parent(String s){
        Stack<Character> st = new Stack<>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty() || st.pop() != '(') return false;
            }
        }
        return st.isEmpty();
    }
    public List<String> dfs (String[] temp, int i){
        if(i == temp.length){
            ArrayList<String> res = new ArrayList<>();
            res.add("");  
            return res; 
        }
        Set<String> resList = new HashSet<>(); 
        List<String> out = dfs(temp, i+1); 
        for(String s : out){
            for(int j = 0; j <= s.length(); j++){
                String result = s.substring(0, j) + temp[i] + s.substring(j);
                resList.add(result); 
            }
        }
        return new ArrayList<>(resList); 
    }
}