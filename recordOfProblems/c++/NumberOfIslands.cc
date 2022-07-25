void addAdjacentsToQueues(std::queue<int>& queueRow, std::queue<int>& queueCol, vector<vector<bool>>& visited, int row, int col, vector<vector<char>>& grid) {
    int maxRows = visited.size();
    int maxCols = visited[0].size();
    if(row > 0 && row < maxRows && col >= 0 && col < maxCols && !visited[row-1][col] && grid[row-1][col]=='1') {   //row-1, col
        queueRow.push(row-1);
        queueCol.push(col);
    }
    if(row >= 0 && row < maxRows-1 && col >= 0 && col < maxCols && !visited[row+1][col] && grid[row+1][col]=='1') {   //row+1, col
        queueRow.push(row+1);
        queueCol.push(col);
    }
    if(row >= 0 && row < maxRows && col > 0 && col < maxCols && !visited[row][col-1] && grid[row][col-1]=='1') {   //row, col-1
        queueRow.push(row);
        queueCol.push(col-1);
    }
    if(row >= 0 && row < maxRows && col >= 0 && col < maxCols-1 && !visited[row][col+1] && grid[row][col+1]=='1') {   //row, col+1
        queueRow.push(row);
        queueCol.push(col+1);
    }
}

void removeIsland(vector<vector<char>>& grid, vector<vector<bool>>& visited, int row, int col) {
    std::queue<int> queueRow;
    std::queue<int> queueCol;
    
    queueRow.push(row);
    queueCol.push(col);
    while(!queueRow.empty() && !queueCol.empty()) {
        int currRow = queueRow.front();
        int currCol = queueCol.front();
        queueRow.pop();
        queueCol.pop();
        if(!visited[currRow][currCol]) {
            visited[currRow][currCol] = true;
            addAdjacentsToQueues(queueRow, queueCol, visited, currRow, currCol, grid);
        }
    }
}

int numIslands(vector<vector<char>>& grid) {
    int nIslands = 0;
    std::vector<std::vector<bool>> visited;
    
    //Initialize all position invisited to false
    for(int i=0; i<grid.size(); i++) {
        std::vector<bool> visitedCol;
        for(int j=0; j<grid[0].size(); j++) {
            visitedCol.push_back(false);
        }
        visited.push_back(visitedCol);
    }
    
    for(int i=0; i<grid.size(); i++) {
        for(int j=0; j<grid[0].size(); j++) {
            if(grid[i][j] == '1' && !visited[i][j]) {
                nIslands++;
                removeIsland(grid, visited, i, j);
            }
        }
    }
    
    return nIslands;
}
