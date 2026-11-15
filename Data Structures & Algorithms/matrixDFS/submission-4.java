class Solution {
    public int countPaths(int[][] grid) {
        int r = grid.length; 
        int c = grid[0].length; 
        boolean[][] visited = new boolean[r][c]; 
        int[] count = new int[1]; 
        count[0] = 0; 
        helper(grid, visited, 0, 0, count); 
        return count[0]; 
    }
    public void helper(int[][] grid, boolean[][]
    visited, int r, int c, int[] count) {
        if(r < 0 || r >= grid.length || c < 0 || c >= 
        grid[0].length || visited[r][c] || grid[r][c]==1) {
            return; 
        }
        if(r == grid.length - 1 && c == grid[0].length - 1) {
            count[0]++; 
            return; 
        }
        visited[r][c] = true; 
        helper(grid, visited, r + 1, c, count); 
        helper(grid, visited, r - 1, c, count); 
        helper(grid, visited, r, c + 1, count); 
        helper(grid, visited, r, c - 1, count); 
        visited[r][c] = false; 
    }
}
