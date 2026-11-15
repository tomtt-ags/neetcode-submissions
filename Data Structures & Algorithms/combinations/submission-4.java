class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outp = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 
        helper(1, n, k, curr, outp); 
        return outp;
    }
    public void helper(int ind, int n, int k, List<Integer> curr,
    List<List<Integer>> outp) {
        if(curr.size() == k) {
            outp.add(new ArrayList<>(curr)); 
            return; 
        }
        
        for(int i = ind; i <= n; i++) { 
            curr.add(i);
            helper(i+1, n, k, curr, outp); 
            curr.removeLast(); 
        }
        return; 
    }
}