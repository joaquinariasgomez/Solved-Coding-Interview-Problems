public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(areEqual(root, subRoot)) return true;
        else {
            if(root == null) return false;
            else {
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            }
        }
    }

    public boolean areEqual(TreeNode node1, TreeNode node2) {
        if((node1 == null && node2 != null) || (node1 != null && node2 == null)) return false;
        if(node1 == null && node2 == null) return true;
        return node1.val == node2.val && areEqual(node1.left, node2.left) && areEqual(node1.right, node2.right);
    }

    public void run() {

    }
    public static void main(String[] args) {
        new SubtreeOfAnotherTree().run();
    }
}