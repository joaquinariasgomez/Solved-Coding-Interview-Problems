import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val; left = null; right = null;}
}

public class GetTreeFromPreorder {

    public TreeNode treeFromPreorder(int[] values, int from, int to) {
        //Split problem in: Node, izq, der
        if(from > to || from == -1) {
            return null;
        }
        TreeNode node = new TreeNode(values[from]);

        int indexGreaterElement = -1;
        for(int i=from+1; i<=to; i++) {
            if(values[i]>node.val) {
                if(indexGreaterElement == -1) {
                    indexGreaterElement = i;
                }
            }
        }
        node.left = treeFromPreorder(values, from+1, indexGreaterElement-1);
        node.right = treeFromPreorder(values, indexGreaterElement, to);
        return node;
    }

    public void preOrder(TreeNode tree) {
        if(tree != null) {
            System.out.print(tree.val+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void BFS(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
            System.out.print(current.val+" ");
        }
    }

    public void run() {
        int[] values = {8, 5, 1, 7, 10, 12};
        TreeNode tree = treeFromPreorder(values, 0, values.length-1);
        preOrder(tree);
        System.out.println();
        BFS(tree);
        System.out.println();
    }
    public static void main(String[] args) {
        new GetTreeFromPreorder().run();
    }
}