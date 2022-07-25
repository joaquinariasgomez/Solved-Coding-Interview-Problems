vector<int> spiralOrder(vector<vector<int>>& matrix) {
    std::vector<int> sol;
    if(matrix.size() == 0) return sol;
    int beginRow = 0;
    int endRow = matrix.size() - 1;
    int beginCol = 0;
    int endCol = matrix[0].size() - 1;
    
    while(beginRow <= endRow && beginCol <= endCol) {
        //Move Right
        for(int i=beginCol; i<=endCol; i++) {
            sol.push_back(matrix[beginRow][i]);
        }
        //Move Down
        for(int i=beginRow+1; i<=endRow; i++) {
            sol.push_back(matrix[i][endCol]);
        }
        //Move Left
        if(beginRow < endRow) {
            for(int i=endCol-1; i>=beginCol; i--) {
                sol.push_back(matrix[endRow][i]);
            }   
        }
        //Move Up
        if(beginCol < endCol) {
            for(int i=endRow-1; i>beginRow; i--) {
                sol.push_back(matrix[i][beginCol]);
            }
        }
        beginRow++;
        beginCol++;
        endRow--;
        endCol--;
    }
    return sol;
}
