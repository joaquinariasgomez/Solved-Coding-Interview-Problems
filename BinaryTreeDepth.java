public class BinaryTreeDepth {
    class TreeNode {
        public TreeNode left, right;
        public int value;
        public TreeNode(int value) {
            this.value=value;
            left=null; right=null;
        }
    }

    public boolean isLeave(TreeNode tree) {
        return tree.left == null && tree.right == null;
    }

    public int calculateMaxDepth(TreeNode tree) {
        if(tree == null) {
            return 0;
        }
        else {
            if(!isLeave(tree)) {
                return 1 + Math.max(calculateMaxDepth(tree.left), calculateMaxDepth(tree.right));
            }
            else {
                return 1;
            }
        }
    }

    public int anotherCalculateMaxDepth(TreeNode tree) {
        if(tree == null) return 0;
        return 1 + Math.max(anotherCalculateMaxDepth(tree.left), anotherCalculateMaxDepth(tree.right));
    }

    public void run() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        node.right = new TreeNode(7);
        System.out.println(anotherCalculateMaxDepth(node));
    }
    public static void main(String[] args) {
        new BinaryTreeDepth().run();
    }
}