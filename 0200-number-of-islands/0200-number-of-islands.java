class Solution {
    
    final char LAND = '1';
    final char WATER = '0';
    char[][] grid;
    boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == WATER || visited[i][j] == true) continue;
                count++;
                dfs(i, j);
            }
        }
        
        return count;
        
    }
    
    // recusive call for each adjacent node
    private void dfs(int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        
        // check if water, check if visited
        if(grid[row][col] == WATER || visited[row][col]) return;
        
        // mark the cell visited
        visited[row][col] = true;
        
        // dfs all four directions
        dfs(row + 1, col);  //  DOWN
        dfs(row - 1, col);  //  UP
        dfs(row, col - 1);  //  LEFT
        dfs(row, col + 1);  //  RIGHT
    }
}