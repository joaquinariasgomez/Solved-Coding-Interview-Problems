public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null || q == null) {
        return p == q;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
}
