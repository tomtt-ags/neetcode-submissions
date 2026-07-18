class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] arr = new boolean[1]; 
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                existence(board, word, i, j, 0, arr);
                if(arr[0]==true) break;  
            }
            if(arr[0]==true) break;  
        }
        return arr[0]; 
    }
    public void existence(char[][]board, String word, int r, int c, int index, boolean[] arr){
        if(arr[0] || index == word.length()){
            arr[0] = true; 
            return; 
        }
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)){
            return; 
        }
        
        char temp = board[r][c];
        board[r][c] = '#';
        existence(board, word, r+1, c, index + 1, arr); 
        existence(board, word, r-1, c, index + 1, arr); 
        existence(board, word, r, c+1, index + 1, arr); 
        existence(board, word, r, c-1, index + 1, arr); 
        board[r][c] = temp;
    }
}