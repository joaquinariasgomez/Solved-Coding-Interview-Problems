public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isValidBSTDFS(root, min, max);
    }

    public boolean isValidBSTDFS(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBSTDFS(root.left, min, root.val) && isValidBSTDFS(root.right, root.val, max);
    }

    public void run() {

    }

    public static vois main(String[] args) {
        new ValidateBinarySearchTree().run();
    }
}