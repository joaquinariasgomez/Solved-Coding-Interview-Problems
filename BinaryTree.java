import java.util.LinkedList;

public class BinaryTree {

    class TreeNode {
        TreeNode(int val) {this.val = val; left=null; right=null;}
        void print() {
            System.out.print(this.val+" ");
        }
        boolean isLeaf() {
            return left == null && right == null;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }

    private void preorderTree(TreeNode root) {
        if(root != null) {
            root.print();
            preorderTree(root.left);
            preorderTree(root.right);
        }
    }

    private void inorderTree(TreeNode root) {
        if(root != null) {
            inorderTree(root.left);
            root.print();
            inorderTree(root.right);
        }
    }

    private void postorderTree(TreeNode root) {
        if(root != null) {
            postorderTree(root.left);
            postorderTree(root.right);
            root.print();
        }
    }

    public void printTreeTraversals(TreeNode root) {
        System.out.print("Preorder: ");
        preorderTree(root);
        System.out.print("\nInorder: ");
        inorderTree(root);
        System.out.print("\nPostorder: ");
        postorderTree(root);
        System.out.println();
    }

    public TreeNode deepCopy(TreeNode root) {
        if(root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = deepCopy(root.left);
        newRoot.right = deepCopy(root.right);
        return newRoot;
    }

    private void run() {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(5);
        tree.right.left = new TreeNode(4);
        tree.left = new TreeNode(2);
        printTreeTraversals(tree);
        TreeNode copy = deepCopy(tree);
        printTreeTraversals(copy);
    }

    public static void main(String[] args) {
        new BinaryTree().run();
    }
}
