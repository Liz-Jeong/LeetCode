class Solution {
    
    char[][] metrix;
    char[] letters;
    boolean visited[][];    // can not visit already visited letter
    
    public boolean exist(char[][] board, String word) {
        
        int rowLen = board.length, colLen = board[0].length;
        metrix = board;
        letters = word.toCharArray();
        
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(board[i][j] == letters[0]) {
                    visited = new boolean[rowLen][colLen];
                    boolean res = DFS(i, j, 0);
                    if(res) return true;
                }
            }
        }
        
        return false;
        
    }
    
    private boolean DFS(int curRow, int curCol, int curIdx) {
        
        // basic case
        if(curRow < 0 || curRow >= metrix.length) return false;
        if(curCol < 0 || curCol >= metrix[0].length) return false;
        if(visited[curRow][curCol]) return false;
        if(metrix[curRow][curCol] != letters[curIdx]) return false;
        
        // end of string
        if(curIdx == letters.length - 1) return true;
        visited[curRow][curCol] = true;
        
        // DFS for 4 directions
        boolean top = DFS(curRow - 1, curCol, curIdx + 1);
        boolean down = DFS(curRow + 1, curCol, curIdx + 1);
        boolean left = DFS(curRow, curCol - 1, curIdx + 1);
        boolean right = DFS(curRow, curCol + 1, curIdx + 1);
        
        boolean ans = top || down || left || right;
        if(!ans) {
            visited[curRow][curCol] = false;
        }
        return ans;
    }
}