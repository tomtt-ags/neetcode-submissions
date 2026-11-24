class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //you want matrix dfs from each node tht is a 1 
        //&& not visited, on each call maintain a count 
        //if the returned count is greater than one stored 
        //store it. 
        //in the backtracking don't remove anything keep 
        //track of count by returning the actual count in 
        //our helper function. 
        //the count should be sum of counts from recursion in 
        //each direction. 
        int out = 0; 
        int rows = grid.length; 
        int cols = grid[0].length; 
        HashSet<String> set = new HashSet<>(); 
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    int[] count = {0}; 
                    dfs(grid, i, j, set, count);
                    out = Math.max(out, count[0]); 
                }
            }
        }
        return out; 
    }
    public void dfs(int[][] grid, int r, int c, HashSet<String> set, int[] count) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
        || set.contains(r + "," + c) || grid[r][c] == 0){
            return; 
        }
        set.add(r + "," + c); 
        count[0]++; 
        dfs(grid, r+1, c, set, count); 
        dfs(grid, r-1, c, set, count); 
        dfs(grid, r, c+1, set, count); 
        dfs(grid, r, c-1, set, count); 
    }
}

