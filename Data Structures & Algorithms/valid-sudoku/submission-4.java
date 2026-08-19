class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 3 methods, checkRows, checkCols & checkGrid, return
        //true if all 3 of these return true, need to convert characters 
        //to int as well
        return checkRows(board) && checkCols(board) && checkGrid(board); 
    }
    //some helper methods.
    public ArrayList<Integer> toNumeric (char[] c)
    {
        ArrayList<Integer> check = new ArrayList<>(); 
        for(int i = 0; i < c.length; i++)
        {
            if(c[i] == '.') continue; 
            check.add(Character.getNumericValue(c[i]));
        }
        return check; 
    }
    public boolean validArr(char[] inp)
    {
        ArrayList<Integer> check = toNumeric(inp); 
        HashSet<Integer> set = new HashSet<>(); 
        for(int i = 0; i < check.size(); i++){
            if(check.get(i)>9 || check.get(i) < 1) return false; 
            if(set.contains(check.get(i))){
                return false; 
            } else {
                set.add(check.get(i)); 
            }
        }
        return true; 
    }
    //start by checking rows
    public boolean checkRows(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            if(!validArr(board[i])) return false; 
        }
        return true;
    }
    public boolean checkCols(char[][] board) {
        for (int c = 0; c < 9; c++) {
            char[] col = new char[9];
            for (int r = 0; r < 9; r++) {
                col[r] = board[r][c];
            }
            if (!validArr(col)) return false;
        }
        return true;
    }
    public boolean checkGrid(char[][] board) {
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                char[] box = new char[9];
                int idx = 0;
                for (int r = boxRow * 3; r < boxRow * 3 + 3; r++) {
                    for (int c = boxCol * 3; c < boxCol * 3 + 3; c++) {
                        box[idx++] = board[r][c];
                    }
                }
                if (!validArr(box)) return false;
            }
        }
        return true;
    }
}
