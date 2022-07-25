vector<int> inorderTraversal(TreeNode* root) {
    std::stack<TreeNode*> stack;
    std::vector<int> sol;
    TreeNode* curr = root;
    
    while(curr != nullptr || !stack.empty()) {
        if(curr != nullptr) {
            stack.push(curr);
            curr = curr->left;
        }
        else {
            curr = stack.top();
            stack.pop();
            sol.push_back(curr->val);
            curr = curr->right;
        }
    }
    
    return sol;
}

// O(N) time complexity
// O(h) space complexity, where 'h' is the height of the tree. 'h' at max can be 'N'
