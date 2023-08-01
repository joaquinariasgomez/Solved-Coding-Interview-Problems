public class DiameterBinaryTree {
    class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int val) {
            this.val=val;
        }
    }

    public int getMaxDiameter(TreeNode root) {
        int[] maxDiameter = {0};
        maxHeight(root, maxDiameter);
        return maxDiameter[0];
    }

    public int maxHeight(TreeNode root, int[] maxDiameter) {
        if(root == null)
            return 0;
        int leftHeight = maxHeight(root.left, maxDiameter);
        int rightHeight = maxHeight(root.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight+rightHeight);
        int height = 1+Math.max(leftHeight, rightHeight);
        return height;
    }

    public void run() {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.left.left = new TreeNode(4);
        tree.right.right = new TreeNode(6);
        System.out.println(getMaxDiameter(tree));
    }
    public static void main(String[] args) {
        new DiameterBinaryTree().run();
    }
}