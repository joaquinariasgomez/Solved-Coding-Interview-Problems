void addAdjacentsToQueues(std::queue<int>& queueRow, std::queue<int>& queueCol, int row, int col, vector<vector<char>>& grid) {
    int maxRows = grid.size();
    int maxCols = grid[0].size();
    if(row > 0 && row < maxRows && col >= 0 && col < maxCols && grid[row-1][col]=='1') {   //row-1, col
        queueRow.push(row-1);
        queueCol.push(col);
    }
    if(row >= 0 && row < maxRows-1 && col >= 0 && col < maxCols && grid[row+1][col]=='1') {   //row+1, col
        queueRow.push(row+1);
        queueCol.push(col);
    }
    if(row >= 0 && row < maxRows && col > 0 && col < maxCols && grid[row][col-1]=='1') {   //row, col-1
        queueRow.push(row);
        queueCol.push(col-1);
    }
    if(row >= 0 && row < maxRows && col >= 0 && col < maxCols-1 && grid[row][col+1]=='1') {   //row, col+1
        queueRow.push(row);
        queueCol.push(col+1);
    }
}

void removeIsland(vector<vector<char>>& grid, int row, int col) {
    std::queue<int> queueRow;
    std::queue<int> queueCol;
    
    queueRow.push(row);
    queueCol.push(col);
    while(!queueRow.empty() && !queueCol.empty()) {
        int currRow = queueRow.front();
        int currCol = queueCol.front();
        queueRow.pop();
        queueCol.pop();
        if(grid[currRow][currCol] == '1') {
            grid[currRow][currCol] = '0';
            addAdjacentsToQueues(queueRow, queueCol, currRow, currCol, grid);
        }
    }
}

int numIslands(vector<vector<char>>& grid) {
    int nIslands = 0;
    
    for(int i=0; i<grid.size(); i++) {
        for(int j=0; j<grid[0].size(); j++) {
            if(grid[i][j] == '1') {
                nIslands++;
                removeIsland(grid, i, j);
            }
        }
    }
    
    return nIslands;
}
