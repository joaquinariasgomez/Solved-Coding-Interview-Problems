public class MaximumDepthOfBinaryTree {
    class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int val) {
            this.val=val;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public void run() {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.left.left = new TreeNode(4);
        System.out.println(maxDepth(tree));
    }
    public static void main(String[] args) {
        new MaximumDepthOfBinaryTree().run();
    }
}