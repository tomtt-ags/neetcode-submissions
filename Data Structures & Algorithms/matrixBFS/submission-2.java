class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length; 
        int COLS = grid[0].length; 
        if(grid[0][0] == 1 || grid[ROWS-1][COLS-1] == 1) return -1; 
        Queue<int[]> q = new ArrayDeque<>(); 
        HashSet<String> visit = new HashSet<>(); 
        q.add(new int[] {0, 0}); 
        visit.add("0,0"); 
        int length = 0; 
        while(!q.isEmpty()) {
            int size = q.size(); 
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll(); 
                int r = cell[0]; 
                int c = cell[1];
                if(r == ROWS - 1 && c == COLS - 1) {
                    return length; 
                }
                int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
                for(int[] neighbor : neighbors) {
                    int nr = r + (neighbor[0]); 
                    int nc = c + (neighbor[1]); 
                    if(nr < 0 || nc < 0 || nr == ROWS || nc == COLS 
                    || grid[nr][nc] == 1 || visit.contains(nr + "," + nc))
                    {
                        continue; 
                    }
                    q.add(new int[] {nr, nc}); 
                    visit.add(nr + "," + nc);
                }
            }
            length++; 
        }
        return -1; 
    }
}
