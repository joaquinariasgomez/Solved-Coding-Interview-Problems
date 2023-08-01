public class BinaryTreeMaximumPathSum {
    class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int val) {
            this.val=val;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] maxPath = {root.val};
        maxPathDFS(root, maxPath);
        return maxPath[0];
    }

    public int maxPathDFS(TreeNode root, int[] maxPath) {
        if(root == null) return 0;
        // Max of: splitting vs not splitting. If we split, we cannot split in the childs. The recursive function does not split. The maxPath recalculation is with splitting
        int leftMax = maxPathDFS(root.left, maxPath);
        int rightMax = maxPathDFS(root.right, maxPath);
        leftMax = Math.max(0, leftMax);
        rightMax = Math.max(0, rightMax);

        maxPath[0] = Math.max(maxPath[0], root.val+leftMax+rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

    public void run() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);
        System.out.println(maxPathSum(tree));
    }
    public static void main(String[] args) {
        new BinaryTreeMaximumPathSum().run();
    }
}