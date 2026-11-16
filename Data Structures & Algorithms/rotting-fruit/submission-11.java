class Solution {
    public int orangesRotting(int[][] grid) {
        //bfs is the sol, identify each rotting orange and push it to the 
        //queue. the first layer is the rotting oranges, then next layer is
        //all adjacent fresh oranges that are not visited, modify the 
        //index and change it to 2 keep going till no more adjacent
        //unvisited nodes left. 
        int ro = grid.length; 
        int co = grid[0].length; 
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < ro; i++) {
            for(int j = 0; j < co; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i, j}); 
                }
            }
        }
        while(!q.isEmpty()) {
            int size = q.size(); 
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll(); 
                int r = curr[0]; 
                int c = curr[1]; 
                //visit.add(r + "," + c);
                int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
                for(int[] neighbor : neighbors){
                    int nr = r + neighbor[0]; 
                    int nc = c + neighbor[1]; 
                    if(Math.min(nr, nc) < 0 || nr >= grid.length
                    || nc >= grid[0].length || grid[nr][nc] == 0 || grid[nr][nc] == 2
                    ){
                        continue; 
                    }
                    grid[nr][nc] = 2;
                    q.add(new int[] {nr, nc}); 
                }
            }
            count += 1; 
        }
        for(int i = 0; i < ro; i++) {
            for(int j = 0; j < co; j++){
                if(grid[i][j] == 1){
                    return -1; 
                }
            }
        }
        if(count == 0) return 0; 
        return count-1; 
    }
}
