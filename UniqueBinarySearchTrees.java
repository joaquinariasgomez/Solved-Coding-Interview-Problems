import java.util.List;
import java.util.ArrayList;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int val) {this.val = val; left = null; right = null;}
}

public class UniqueBinarySearchTrees {

    public void printPreorder(TreeNode tree) {
        if(tree != null) {
            System.out.print(tree.val+" ");
            printPreorder(tree.left);
            printPreorder(tree.right);
        }
    }

    public List<TreeNode> AddItems(int from, int to) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(from > to) {
            trees.add(null);
            return trees;
        }

        for(int child=from; child<=to; child++) {
            List<TreeNode> left = AddItems(from, child-1);
            List<TreeNode> right = AddItems(child+1, to);

            for(TreeNode leftTree : left) {
                for(TreeNode rightTree : right) {
                    TreeNode current = new TreeNode(child);
                    current.left=leftTree;
                    current.right=rightTree;
                    trees.add(current);
                }
            }
        }
        return trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0) {
            return new ArrayList<TreeNode>();
        }
        else {
            return AddItems(1, n);
        }
    }

    public void run() {
        int n = 3;
        List<TreeNode> trees = generateTrees(n);
        for(int i=0; i<trees.size(); i++) {
            printPreorder(trees.get(i));
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new UniqueBinarySearchTrees().run();
    }
}