public class PreorderTraversal {
    class Node  {
        public Node(int data) {
            this.data = data;
        }

        int data;
        Node right;
        Node left;
    }

    public void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void run() {
        Node tree = new Node(1);
        tree.right = new Node(2);
        tree.right.right = new Node(5);
        tree.right.right.left = new Node(3);
        tree.right.right.right = new Node(6);
        tree.right.right.left.right = new Node(4);
        preOrder(tree);
    }

    public static void main(String[] args) {
        new PreorderTraversal().run();
    }
}
