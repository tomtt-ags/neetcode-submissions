class Solution {
    public boolean isValidSudoku(char[][] board) {
        //just got to check each row, coloumn doesn't have duplicates
        //and contains elements 1-9. 
        //as well as each 3x3 grid. 
        boolean checkRow = true; 
        for(int i = 0; i < board.length; i++){
            if(checkNum(board[i]) == false || noDuplicate(board[i]) == false){
                checkRow = false; 
                break; 
            }
        }
        boolean checkCol = true; 
        char[] col = new char[9];
        int count = 0; 
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                col[count] = board[j][i];
                count++;  
            }
            if(noDuplicate(col) == false || checkNum(col) == false){
                checkCol = false; 
                break; 
            }
            count = 0; 
        }
        boolean checkGrid = true; 
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {

                char[][] smallGrid = getBox(board, boxRow, boxCol);

                if(isValidGrid(smallGrid) == false){
                    checkGrid = false; 
                    break; 
                }  
            }
        }
        if(checkRow && checkCol && checkGrid){
            return true; 
        } else {
            return false; 
        }
    }
    public char[][] getBox(char[][] board, int row, int col){
        char[][] out = new char[3][3]; 
        int startRow = row*3; 
        int startCol = col*3; 
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                out[r][c] = board[startRow + r][startCol + c];
            }
        }
        return out; 
    }
    public boolean noDuplicate(char[] test){
        HashSet<Character> check = new HashSet<>(); 
        for(int i = 0; i < test.length; i++){
            if(check.contains(test[i])){
                return false; 
            }
            if(test[i]!='.'){
                check.add(test[i]); 
            }
        }
        return true; 
    }
    public boolean checkNum(char[] testNum){
        for(int i = 0; i < testNum.length; i++){
            if(testNum[i] =='.') continue; 
            if(Character.getNumericValue(testNum[i])>9){
                return false; 
            }
        }
        return true; 
    }
    public boolean isValidGrid(char[][] grid){
        char[] flat = new char[9]; 
        HashMap<Integer, Integer> check = new HashMap<>(); 
        int ind = 0; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                flat[ind] = grid[i][j]; 
                ind++; 
            }
        }
        if(checkNum(flat) && noDuplicate(flat)) return true; 
        return false; 
    }
}
