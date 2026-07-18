class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> out = new ArrayList<>(); 
        List<Integer>curr = new ArrayList<>(); 
        dfs(out, curr, 1, n, k); 
        return out; 
    }
    public void dfs(List<List<Integer>> out, List<Integer>curr, int i, int n, int k){
        if(curr.size() == k){
            out.add(new ArrayList<>(curr));
            return;  
        }
        if(i > n) return; 
        for(int j = i; j < n+1; j++){
            curr.add(j); 
            dfs(out, curr, j+1, n, k);
            curr.remove(curr.size()-1); 
        }
    }
}