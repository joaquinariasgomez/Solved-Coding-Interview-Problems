import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null) return sol;
        queue.add(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0; i<queueSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            sol.add(level);
        }
        return sol;
    }

    public void run() {
        TreeNode tree = new TreeNode(3);
        tree.right = new TreeNode(20);
        tree.left = new TreeNode(9);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        List<List<Integer>> sol = levelOrder(tree);
    }
    public static void main(String[] args) {
        new BinaryTreeLevelOrderTraversal().run();
    }
}