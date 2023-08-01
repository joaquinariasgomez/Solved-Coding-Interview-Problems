public class InvertBinaryTree {
    class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int val) {
            this.val=val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    public void run() {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.left = new TreeNode(3);
        TreeNode sol = invertTree(tree);
    }
    public static void main(String[] args) {
        new InvertBinaryTree().run();
    }
}