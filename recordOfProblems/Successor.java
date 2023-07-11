// Write an algorithm to find the "next" node (in-order successor)
// of a given node on a BST. Each node has a link to its parent.
public class Successor {
    class TreeNode {
        public TreeNode left, right, parent;
        public int value;
        public TreeNode(int value) {
            this.value=value;
            left=null; right=null; parent=null;
        }
    }

    public void InOrder(TreeNode root) {
        if(root != null) {
            InOrder(root.left);
            System.out.print(root.value+" ");
            InOrder(root.right);
        }
    }

    public TreeNode getLeftMostElement(TreeNode root) {
        if(root.left == null) {
            return root;
        }
        else {
            return getLeftMostElement(root.left);
        }
    }

    public TreeNode getNextInOrderSuccessor(TreeNode root, TreeNode node) {
        if(node == null) return null;
        if(node.right != null) {
            return getLeftMostElement(node.right);
        }
        else {
            TreeNode current = node;
            TreeNode parent = current.parent;
            while(parent != null && parent.left != current) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public void run() {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.parent = root;
        root.right.left = new TreeNode(7);
        root.right.left.parent = root.right;
        root.left = new TreeNode(3);
        root.left.parent = root;
        root.left.left = new TreeNode(1);
        root.left.left.parent = root.left;
        root.left.right = new TreeNode(4);
        root.left.right.parent = root.left;
        InOrder(root);
        System.out.println("Next successor for 3 is "+getNextInOrderSuccessor(root, root.left).value);
        System.out.println("Next successor for 4 is "+getNextInOrderSuccessor(root, root.left.right).value);
    }

    public static void main(String[] args) {
        new Successor().run();
    }
}