public class ArithmeticBinaryTree {
    public enum Operation {ADD, MINUS, TIMES, NULL};

    class TreeNode {
        public TreeNode left, right;
        public int value;
        public Operation operation;
        public TreeNode(int value) {
            this.value=value;
            this.operation = Operation.NULL;
            left=null; right=null;
        }
        public TreeNode(Operation operation) {
            this.operation = operation;
            left=null; right=null;
        }
    }

    public int calculate(TreeNode tree) {
        if(tree != null) {
            if(tree.operation != Operation.NULL) {
                if(tree.operation == Operation.ADD) {
                    return calculate(tree.left) + calculate(tree.right);
                }
                else if(tree.operation == Operation.MINUS) {
                    return calculate(tree.left) - calculate(tree.right);
                }
                else {
                    return calculate(tree.left) * calculate(tree.right);
                }
            }
            else {
                return tree.value;
            }
        }
        return 0;
    }

    public void run() {
        TreeNode node = new TreeNode(Operation.ADD);
        node.left = new TreeNode(Operation.TIMES);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(Operation.MINUS);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        node.right = new TreeNode(3);
        System.out.println(calculate(node));
    }
    public static void main(String[] args) {
        new ArithmeticBinaryTree().run();
    }
}