class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outp = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 
        helper(1, n, k, curr, outp); 
        return outp;
    }
    public void helper(int i, int n, int k, List<Integer> curr,
    List<List<Integer>> outp) {
        if(curr.size() == k) {
            outp.add(new ArrayList<>(curr)); 
            return; 
        }
        if(i <= n) {
            curr.add(i); 
        } else {
            return; 
        }
        helper(i+1, n, k, curr, outp); 
        curr.removeLast(); 
        helper(i+1, n, k, curr, outp); 
    }
}