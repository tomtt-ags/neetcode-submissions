class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] rotten = new boolean[grid.length][grid[0].length]; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j}); 
                    rotten[i][j] = true; 
                }
            }
        }
        int time = 0; 
        int[] move1 = {0, 0, 1, -1}; 
        int[] move2 = {1, -1, 0, 0}; 
        while(!q.isEmpty()){
            int l = q.size(); 
            for(int i = 0; i < l; i++){
                int[] curr = q.poll(); 
                for(int j = 0; j < 4; j++){
                    int newR = curr[0] + move1[j]; 
                    int newC = curr[1] + move2[j]; 
                    if(newR < 0 || newR >= grid.length || newC < 0 
                    || newC >= grid[0].length) continue; 
                    if(rotten[newR][newC]) continue;
                    if(grid[newR][newC] == 1){ 
                        grid[newR][newC] = 2; 
                        q.add(new int[]{newR, newC}); 
                        rotten[newR][newC] = true; 
                    }
                }
            }
            if(!q.isEmpty()) time++; 
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;  
                }
            }
        }
        return time; 
    }
}
