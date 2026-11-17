class Solution {
    public int climbStairs(int n) {
        //we make a choice at each node whether to decrement
        //n by 1 step or 2 steps. 
        // when n == 0 you will return 1. 
        //you want to sum all the 1s up as your output. 
        //lots of repeated work, so cache your recursions. 
        // HashMap<Integer, Integer> mp = new HashMap<>(); 
        // return dfs(n, mp); 
        //memoization. 
        int[] dfs = new int[2]; 
        if(n <= 2) return n; 
        dfs[0] = 1; 
        dfs[1] = 2; 
        int i = 3;
        while(i<=n){
            int tmp = dfs[1]; 
            int curr = dfs[1] + dfs[0]; 
            dfs[1] = curr; 
            dfs[0] = tmp; 
            i++;
        } 
        return dfs[1]; 
    }
    // public int dfs(int n, HashMap<Integer, Integer> mp) {
    //     if(n == 0) {
    //         return 1; 
    //     }
    //     if(n<0) return 0; 
    //     if(mp.containsKey(n)) {
    //         return mp.get(n); 
    //     }

    //     mp.put(n, dfs(n-1, mp) + dfs(n-2, mp)); 
    //     return mp.get(n); 
    // }
}
