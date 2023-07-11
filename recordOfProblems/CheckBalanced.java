public class CheckBalanced {
    class TreeNode {
        public int value;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public boolean IsBalanced(TreeNode root) {
        if(root == null) return true;
        int heightDiff = Math.abs(getHeight(root.left)-getHeight(root.right));
        return heightDiff <= 1 && IsBalanced(root.left) && IsBalanced(root.right);
    }

    public void run() {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(7);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(10);
        System.out.println(IsBalanced(tree));
    }
    public static void main(String[] args) {
        new CheckBalanced().run();
    }
}