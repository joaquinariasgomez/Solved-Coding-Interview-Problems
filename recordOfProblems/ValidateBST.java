public class ValidateBST {
    class TreeNode {
        public TreeNode left, right;
        public int value;
        public TreeNode(int value) {
            this.value=value;
            left=null; right=null;
        }
    }

    public boolean IsBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        boolean matchExpectations = root.value >= min && root.value < max;
        return matchExpectations && IsBST(root.left, min, root.value) && IsBST(root.right, root.value, max);
    }

    public void run() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(10);
        node.right.left = new TreeNode(8);
        System.out.println(IsBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    public static void main(String[] args) {
        new ValidateBST().run();
    }
}