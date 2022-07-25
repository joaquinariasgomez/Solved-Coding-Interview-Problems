public class IsBalancedBinaryTree {
    class TreeNode {
        public TreeNode left, right;
        public int value;
        public TreeNode(int value) {
            this.value=value;
            left=null; right=null;
        }
    }

    public int getHeight(TreeNode tree) {
        if(tree == null) {
            return 0;
        }
        else {
            return 1 + Math.max(getHeight(tree.left), getHeight(tree.right));
        }
    }

    public boolean isBalanced(TreeNode tree) {
        if(tree == null) return true;
        return (Math.abs(getHeight(tree.left) - getHeight(tree.right)) <= 1) && isBalanced(tree.left) && isBalanced(tree.right);
    }

    public void run() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(9);
        System.out.println(isBalanced(node));
    }
    public static void main(String[] args) {
        new IsBalancedBinaryTree().run();
    }
}
