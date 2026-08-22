class Solution {
    public boolean isValidSudoku(char[][] board) {
    //     // 3 methods, checkRows, checkCols & checkGrid, return
    //     //true if all 3 of these return true, need to convert characters 
    //     //to int as well
    //     //understand the final method, learn the better way which utilises
    //     //the hashset.
    //     return checkRows(board) && checkCols(board) && checkGrid(board); 
    // }
    // //some helper methods.
    // public ArrayList<Integer> toNumeric (char[] c)
    // {
    //     ArrayList<Integer> check = new ArrayList<>(); 
    //     for(int i = 0; i < c.length; i++)
    //     {
    //         if(c[i] == '.') continue; 
    //         check.add(Character.getNumericValue(c[i]));
    //     }
    //     return check; 
    // }
    // public boolean validArr(char[] inp)
    // {
    //     ArrayList<Integer> check = toNumeric(inp); 
    //     HashSet<Integer> set = new HashSet<>(); 
    //     for(int i = 0; i < check.size(); i++){
    //         if(check.get(i)>9 || check.get(i) < 1) return false; 
    //         if(set.contains(check.get(i))){
    //             return false; 
    //         } else {
    //             set.add(check.get(i)); 
    //         }
    //     }
    //     return true; 
    // }
    // //start by checking rows
    // public boolean checkRows(char[][] board)
    // {
    //     for(int i = 0; i < board.length; i++)
    //     {
    //         if(!validArr(board[i])) return false; 
    //     }
    //     return true;
    // }
    // public boolean checkCols(char[][] board) {
    //     for (int c = 0; c < 9; c++) {
    //         char[] col = new char[9];
    //         for (int r = 0; r < 9; r++) {
    //             col[r] = board[r][c];
    //         }
    //         if (!validArr(col)) return false;
    //     }
    //     return true;
    // }
    // //to check a grid convert each grid into an array
    // //do that by treating our matrix as a three by three grid. 
    // public boolean checkGrid(char[][] board) {
    //     for(int r = 0; r < 3; r++) {
    //         int gridRow = r*3; 
    //         char[] grid = new char[9]; 
    //         for (int c = 0; c < 3; c++) {
    //             int gridCol = c*3;
    //             int pointer = 0;  
    //             for(int i = gridRow; i < gridRow+3; i++) {
    //                 for(int j = gridCol; j < gridCol + 3; j++) {
    //                     grid[pointer] = board[i][j]; 
    //                     pointer++; 
    //                 }
    //             }
    //             if(!validArr(grid)) return false; 
    //         }
    //     }
    //     return true; 
    // }
    //now learn how to do this with the better hashset knowledge. 
    //new idea do a nested for loop, we go through each and every 
    //element in our board and we 'key' it, a key for rows, columns 
    //and grid i guess, if we get duplicates then return false straight
    //away, get through the whole thing no duplicates then good
    HashSet<String> check = new HashSet<>(); 
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                char val = board[r][c]; 
                if(val == '.') continue; 
                String rowKey = "r" + r + val; 
                String colKey = "c" + c + val;  
                String gridKey = "g" + (r/3) + (c/3) + val; 
                //treating the grids like a 2d array that is dumbed down 
                if(check.contains(rowKey) || check.contains(colKey)
                || check.contains(gridKey)){
                    return false;
                } else {
                    check.add(rowKey); 
                    check.add(colKey); 
                    check.add(gridKey); 
                }
            }
        }
        return true; 
    }
}
