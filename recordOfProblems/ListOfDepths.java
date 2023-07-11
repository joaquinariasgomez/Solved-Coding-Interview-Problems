import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class ListOfDepths {

    class TreeNode {
        public int value;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public void preOrder(TreeNode root) {
        if(root != null) {
            System.out.print(root.value+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public List<LinkedList<Integer>> getListOfDepths(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        List<LinkedList<Integer>> sol = new ArrayList<LinkedList<Integer>>();

        nodes.add(root);
        while(!nodes.isEmpty()) {
            int queueSize = nodes.size();
            LinkedList<Integer> currentList = new LinkedList<Integer>();
            for(int i=0; i<queueSize; i++) {
                TreeNode currentNode = nodes.poll();
                currentList.add(currentNode.value);
                if(currentNode.left != null) nodes.add(currentNode.left);
                if(currentNode.right != null) nodes.add(currentNode.right);
            }
            sol.add(currentList);
        }
        return sol;
    } 

    public void run() {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(7);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(10);
        List<LinkedList<Integer>> solution = getListOfDepths(tree);
        for(int i=0; i<solution.size(); i++) {
            LinkedList<Integer> currentList = solution.get(i);
            for(int j=0; j<currentList.size(); j++) {
                System.out.print(currentList.get(j)+"->");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new ListOfDepths().run();
    }
}