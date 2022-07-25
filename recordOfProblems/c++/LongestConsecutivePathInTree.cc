#include<iostream>

class TreeNode {
    public:
        int val;
        TreeNode* left;
        TreeNode* right;
        
        TreeNode(): val(0), left(nullptr), right(nullptr) {}
        TreeNode(int x): val(x), left(nullptr), right(nullptr) {}
};

void printTree(TreeNode* tree) {
    if(tree != nullptr) {
        std::cout << tree->val << std::endl;
        printTree(tree->left);
        printTree(tree->right);
    }
}

int longestConsecutivePath(TreeNode* tree, int currLongestPath) {
    if(tree != nullptr) {
        //Check for childs
        int longestLeftPath = currLongestPath;
        if(tree->left != nullptr && tree->left->val == tree->val + 1) {
            longestLeftPath = 1 + longestConsecutivePath(tree->left, currLongestPath);
        }
        int longestRightPath = currLongestPath;
        if(tree->right != nullptr && tree->right->val == tree->val + 1) {
            longestRightPath = 1 + longestConsecutivePath(tree->right, currLongestPath);
        }
        return std::max(longestLeftPath, longestRightPath);
    }
    else {
        return 0;
    }
}

int longestConsecutivePathCaller(TreeNode* tree) {
    return longestConsecutivePath(tree, 1);
}

int main() {
    TreeNode* tree1 = new TreeNode(1);
    tree1->right = new TreeNode(2);
    tree1->right->right = new TreeNode(3);
    TreeNode* tree2 = new TreeNode(1);
    tree2->left = new TreeNode(2);
    tree2->right = new TreeNode(2);
    tree2->left->left = new TreeNode(4);
    tree2->left->right = new TreeNode(3);
    tree2->left->right->left = new TreeNode(4);
    tree2->right->left = new TreeNode(5);
    tree2->right->right = new TreeNode(8);
    std::cout << longestConsecutivePathCaller(tree1) << std::endl;
    std::cout << longestConsecutivePathCaller(tree2) << std::endl;
}