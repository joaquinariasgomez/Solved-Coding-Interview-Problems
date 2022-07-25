vector<vector<int>> levelOrder(TreeNode* root) {
    std::queue<TreeNode*> queue;
    std::vector<std::vector<int>> sol;
    if(root == nullptr) return sol;
    
    queue.push(root);
    while(!queue.empty()) {
        int currSize = queue.size();
        std::vector<int> currLevel;
        for(int i=0; i<currSize; i++) {
            TreeNode* currNode = queue.front();
            queue.pop();
            currLevel.push_back(currNode->val);
            if(currNode->left != nullptr) queue.push(currNode->left);
            if(currNode->right != nullptr) queue.push(currNode->right);
        }
        sol.push_back(currLevel);
    }
    
    return sol;
}
