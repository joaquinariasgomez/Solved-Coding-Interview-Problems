public class SameTree {
    class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int val) {
            this.val=val;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p!= null && q == null)) return false;
        if(p == null && q == null) return true;
        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public void run() {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        System.out.println(isSameTree(tree1, tree2));
    }
    public static void main(String[] args) {
        new SameTree().run();
    }
}