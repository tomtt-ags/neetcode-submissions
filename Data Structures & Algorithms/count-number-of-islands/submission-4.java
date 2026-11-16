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
                    sink(grid, i, j, visit); 
                }
            }
        }
        return count;  
    }
    public void sink(char[][] grid, int r, int c, HashSet<String> visit) {
        Queue<int[]> q = new ArrayDeque<>(); 
        q.add(new int[] {r, c}); 
        visit.add(r + "," + c);
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll(); 
                grid[curr[0]][curr[1]] = '0'; 
            
                int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
                for(int[] neighbor : neighbors){
                    int nr = curr[0] + neighbor[0]; 
                    int nc = curr[1] + neighbor[1]; 
                    if(Math.min(nr, nc) < 0 || nr >= grid.length ||
                    nc >= grid[0].length || grid[nr][nc] == '0' || visit.contains(nr + "," + nc)) {
                        continue; 
                    }
                    visit.add(nr + "," + nc);
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}