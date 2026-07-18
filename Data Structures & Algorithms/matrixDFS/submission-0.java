class Solution {
    public int countPaths(int[][] grid) {
        int COL = grid.length; 
        int ROW = grid[0].length; 
        return helper(grid, 0, 0, new HashSet<>()); 
    }
    public int helper(int[][] grid, int c, int r, HashSet<String> visit){
        if(Math.min(c, r) < 0 || c == grid.length || r == grid[0].length
        || grid[c][r] == 1 || visit.contains(c + "," + r)){
            return 0; 
        }
        if(c == grid.length - 1 && r == grid[0].length - 1){
            return 1; 
        }
        int count = 0; 
        visit.add(c + "," + r); 
        count += helper(grid, c + 1, r, visit); 
        count += helper(grid, c - 1, r, visit); 
        count += helper(grid, c, r + 1, visit); 
        count += helper(grid, c, r - 1, visit); 
        visit.remove(c + "," + r); 
        return count; 
    }
}
