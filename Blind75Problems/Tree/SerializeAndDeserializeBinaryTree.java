import java.util.Arrays;

public class SerializeAndDeserializeBinaryTree {

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder curr = new StringBuilder();
        serializePreorder(root, curr);
        return curr.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] vals = data.split(",");
        int[] idx = {0};
        TreeNode sol = treeFromPreorder(vals, idx);
        return sol;
    }

    public TreeNode treeFromPreorder(String[] vals, int[] idx) {
        if(vals[idx[0]].equals("N")) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(vals[idx[0]]));
        idx[0]++;
        root.left = treeFromPreorder(vals, idx);
        root.right = treeFromPreorder(vals, idx);
        return root;
    }

    public void serializePreorder(TreeNode root, StringBuilder curr) {
        if(root != null) {
            curr.append(root.val + ",");
            serializePreorder(root.left, curr);
            serializePreorder(root.right, curr);
        }
        else {
            curr.append("N,");
        }
    }

    public void run() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);
        String serialization = serialize(tree);
        System.out.println(serialization);
        TreeNode resultingTree = deserialize(serialization);
        System.out.println(serialize(resultingTree));
    }
    public static void main(String[] args) {
        new SerializeAndDeserializeBinaryTree().run();
    }
}