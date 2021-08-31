class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val; left = null; right = null;}
}

public class ConstructMaximumBST {

    public void preOrder(TreeNode tree) {
        if(tree!=null) {
            System.out.print(tree.val+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    
    public TreeNode buildMaximumTree(int[] nums, int from, int to) {
        if(from > to) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int findIndex = from;
        for(int i=from; i<=to; i++) {
            if(nums[i] > max) {
                max = nums[i];
                findIndex = i;
            }
        }
        TreeNode tree = new TreeNode(max);
        tree.left = buildMaximumTree(nums, from, findIndex-1);
        tree.right = buildMaximumTree(nums, findIndex + 1, to);
        return tree;
    }

    public void run() {
        int[] nums = {3,2,1,6,0,5};
        TreeNode maximumTree = buildMaximumTree(nums, 0, nums.length-1);
        preOrder(maximumTree);
    }
    public static void main(String[] args) {
        new ConstructMaximumBST().run();
    }
}