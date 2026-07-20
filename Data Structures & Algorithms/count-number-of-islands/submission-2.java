class Solution {
    public int numIslands(char[][] grid) {
        //do bfs on each index and mark the 1s as visited, each time you get to a 1 thats not 
        //visited add 1. 
        //ima try it with dfs. 
        int r = grid.length; 
        int c = grid[0].length; 
        boolean [][] visited = new boolean [r][c];
        int count = 0;  
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count++; 
                }
                dfs(grid, visited, i, j); 
            }
        }
        return count; 
    }
    public void dfs(char[][] grid, boolean[][] visited, int r, int c){
        int[] move1 = {0, 0, 1, -1}; 
        int[] move2 = {1, -1, 0, 0}; 
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        if(visited[r][c]) return;
        if(grid[r][c] == '0')return; 
        if(grid[r][c] == '1') visited[r][c] = true;  
        for(int i = 0; i < 4; i++){
            dfs(grid, visited, r + move1[i], c + move2[i]); 
        }
    }
}
