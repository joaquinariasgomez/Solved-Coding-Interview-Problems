import java.util.LinkedList;

public class BinaryTree {

    class TreeNode {
        TreeNode(int val) {this.val = val; left=null; right=null;}
        void print() {
            System.out.println(this.val);
        }
        boolean isLeaf() {
            return left == null && right == null;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }

    private void preorderTree(TreeNode root, TreeNode lastLeafNode) {
        if(root==null || root.isLeaf()) return;

        /*if(root.left != null) {
            if(root.left.isLeaf()) {
                if(lastLeafNode == null) {
                    lastLeafNode = root.left;
                }
                else {
                    lastLeafNode.right = root.left;
                    lastLeafNode = root.left;
                }
            }
        }
        if(root.right != null) {
            if(root.right.isLeaf()) {
                if(lastLeafNode == null) {
                    lastLeafNode = root.right;
                }
                else {
                    lastLeafNode.right = root.right;
                    lastLeafNode = root.right;
                }
            }
        }*/
        root.print();

        preorderTree(root.left, lastLeafNode);
        preorderTree(root.right, lastLeafNode);
    }

    private void run() {
        TreeNode tree = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(5);
        tree.right.left = new TreeNode(4);
        tree.left = new TreeNode(1);
        preorderTree(tree, null);
        // TreeNode leafNode = tree.left;
        // while(leafNode != null) {
        //     leafNode.print();
        //     leafNode = leafNode.right;
        // }
    }

    public static void main(String[] args) {
        new BinaryTree().run();
    }
}
