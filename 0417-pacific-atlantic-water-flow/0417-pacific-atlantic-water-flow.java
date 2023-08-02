class Solution {
    
    int[][] heights;
    int M, N;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        List<List<Integer>> res = new LinkedList<>();   // frequent data changes
        
        // DFS First row and First col (Pacific)
        this.M = heights.length;
        this.N = heights[0].length;
        boolean[][] pacificTable = new boolean[M][N];
        iterateRow(0, pacificTable);
        iterateCol(0, pacificTable);
        
       // DFS First row and First col (Atlantic)
        boolean[][] atlanticTable = new boolean[M][N];
        iterateRow(M - 1, atlanticTable);   // M - 1번째 Row 탐색
        iterateCol(N - 1, atlanticTable);   // N - 1번째 Col 탐색
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(pacificTable[i][j] == true && atlanticTable[i][j] == true) {
                    // [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
                    res.add(Arrays.asList(new Integer[] { i, j })); // Array -> to List
                }
            }
        }
        
        return res;
    }
    
    private void DFS(int row, int col, boolean[][] visited) {
        
        if(visited[row][col] == false) visited[row][col] = true;
        
        int currCellVal = heights[row][col];
        
        // Top
        if(0 <= row - 1 && heights[row - 1][col] >= currCellVal && visited[row - 1][col] == false) {
            DFS(row - 1, col, visited);
        }
        // Down
        if(row + 1 < M && heights[row + 1][col] >= currCellVal && visited[row + 1][col] == false) {
            DFS(row + 1, col, visited);
        }
        // Left
        if(0 <= col - 1 && heights[row][col - 1] >= currCellVal && visited[row][col - 1] == false) {
            DFS(row, col - 1, visited);
        }
        // Right
        if(col + 1 < N && heights[row][col + 1] >= currCellVal && visited[row][col + 1] == false) {
            DFS(row, col + 1, visited);
        }
    }
    
    private void iterateRow(int row, boolean[][] visited) {
        // iterateRow(0, pacificTable);
        
        int totalCols = N;
        for(int i = 0; i < totalCols; i++) {
            int currCol = i;
            DFS(row, currCol, visited);
        }
    }
    
     private void iterateCol(int col, boolean[][] visited) {
        int totalRows = M;
        for(int i = 0; i < totalRows; i++) {
            int currRow = i;
            DFS(currRow, col, visited);
        }
    }
}