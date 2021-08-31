class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val; left = null; right = null;}
}

public class IsBinarySearchTree {
    public boolean isBST(TreeNode tree, int min, int max) {
        if(tree == null) {
            return true;
        }
        if(tree.val < min || tree.val >= max) {
            return false;
        }
        return isBST(tree.left, min, tree.val) && isBST(tree.right, tree.val, max);
    }

    public boolean isBST(TreeNode tree) {
        return isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void run() {
        TreeNode tree = new TreeNode(9);
        tree.left = new TreeNode(7);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(8);
        tree.right.right = new TreeNode(12);
        System.out.println(isBST(tree));
    }
    public static void main(String[] args) {
        new IsBinarySearchTree().run();
    }
}