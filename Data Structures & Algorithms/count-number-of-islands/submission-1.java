class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        int count = 0; 
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1' && visited[r][c] == false){
                    bfs(r, c, grid, visited); 
                    count++; 
                }
            }
        }
        return count; 
    }
    public void bfs(int r, int c, char[][] grid, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>(); 
        q.add(new int[]{r, c}); 
        visited[r][c] = true; 
        int[] move1 = {1, -1, 0, 0}; 
        int[] move2 = {0, 0, 1, -1}; 
        while(!q.isEmpty()){
            int[] curr = q.poll(); 
            for(int i = 0; i < 4; i++){
                int newR = curr[0] + move1[i]; 
                int newC = curr[1] + move2[i]; 
                if(newR < 0 || newR >= grid.length || newC < 0 
                || newC >= grid[0].length) continue; 
                if(visited[newR][newC]) continue; 
                if(grid[newR][newC] == '1'){
                    visited[newR][newC] = true; 
                    q.add(new int[]{newR, newC}); 
                }
            }
        }
    }
}
