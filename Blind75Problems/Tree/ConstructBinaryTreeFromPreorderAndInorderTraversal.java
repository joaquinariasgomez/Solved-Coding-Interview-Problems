import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean areEqualTrees(TreeNode tree1, TreeNode tree2) {
        if((tree1 == null && tree2 != null) || (tree1 != null && tree2 == null)) return false;
        if(tree1 == null && tree2 == null) return true;
        return tree1.val == tree2.val && areEqualTrees(tree1.left, tree2.left) && areEqualTrees(tree1.right, tree2.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int midIndex = 0;
        for(int i=0; i<inorder.length; i++)
            if(inorder[i] == preorder[0])
                midIndex = i;

        root.left = buildTree(
                    Arrays.copyOfRange(preorder, 1, preorder.length),
                    Arrays.copyOfRange(inorder, 0, midIndex)  
                    );
        root.right = buildTree(
                    Arrays.copyOfRange(preorder, midIndex+1, preorder.length),
                    Arrays.copyOfRange(inorder, midIndex+1, inorder.length)  
                    );
        return root;
    }

    public void run() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {2, 1, 4, 3, 5};
        TreeNode result = buildTree(preorder, inorder);
        System.out.println(areEqualTrees(tree, result));
    }
    
    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreorderAndInorderTraversal().run();
    }
}