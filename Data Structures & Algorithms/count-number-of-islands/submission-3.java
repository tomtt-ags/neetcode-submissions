class Solution {
    public int numIslands(char[][] grid) {
        //find each island, when you find an island sink the entire island
        //before continuing. 
        int r = grid.length; 
        int c = grid[0].length; 
        HashSet<String> visit = new HashSet<>(); 
        int count = 0; 
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1'){
                    count++; 
                }
                sink(grid, i, j, visit); 
            }
        }
        return count;  
    }
    public void sink(char[][] grid, int r, int c, HashSet<String> visit) {
        if(Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length
        || visit.contains(r + "," + c) || grid[r][c] == '0'){
            return; 
        }
        if(grid[r][c] == '1'){
            grid[r][c] = '0'; 
        }
        visit.add(r + "," + c); 
        sink(grid, r+1, c, visit); 
        sink(grid, r-1, c, visit); 
        sink(grid, r, c+1, visit); 
        sink(grid, r, c-1, visit); 
        visit.remove(r+","+c); 
    }
}
