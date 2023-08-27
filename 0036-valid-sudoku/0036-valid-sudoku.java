class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        int rowLen = board.length;
        int colLen = board[0].length;
        
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                
                char curVal = board[i][j];
                
                if(curVal != '.') {
                    if(!set.add(curVal + " found in row " + i) ||
                      !set.add(curVal + " found in col " + j) ||
                      !set.add(curVal + " found in sub box " + i/3 + "-" + j/3)) return false;
                }
            }
        }
        
        return true;
    }
}