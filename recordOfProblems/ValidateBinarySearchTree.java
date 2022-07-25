public boolean isBST(TreeNode root, long minValue, long maxValue) {
    if(root == null) return true;

    if(root.val <= minValue || root.val >= maxValue) {
        return false;
    }
    return isBST(root.left, minValue, root.val) && isBST(root.right, root.val, maxValue);
}

public boolean isValidBST(TreeNode root) {
    return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
