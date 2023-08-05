class Solution {

    final int WATER = 0;
    final int LAND = 1;
    int countArea;
    int[][] grid;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        
        int maxArea = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == true || grid[i][j] == WATER) continue;
                DFS(i, j);
                maxArea = Math.max(maxArea, countArea);
                // initialize number of area
                countArea = 0;
            }
        }

        return maxArea;
    }

    private void DFS(int row, int col) {
        // check the boundary
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        // check if it is water
        if(grid[row][col] == WATER || visited[row][col] == true) return;

        // mark the cell visited
        visited[row][col] = true;
        // increment the number of area
        countArea++;

        // traverse all four directions
        DFS(row - 1, col); // UP
        DFS(row + 1, col); // DOWN
        DFS(row, col - 1); // LEFT
        DFS(row, col + 1); // RIGHT
    }

}