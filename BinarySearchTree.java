class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val; left = null; right = null;}
}

public class BinarySearchTree {

    public void preOrder(TreeNode tree) {
        if(tree != null) {
            System.out.print(tree.val+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public TreeNode insertToTree(TreeNode tree, int element) {
        if(tree == null) {
            return new TreeNode(element);
        }
        else {
            if(element < tree.val) {
                tree.left = insertToTree(tree.left, element);
            }
            else {
                tree.right = insertToTree(tree.right, element);
            }
            return tree;
        }
    }

    public TreeNode deleteFromTree(TreeNode tree, int element) {
        if(tree == null) {
            return tree;
        }
        else {
            if(element < tree.val) {
                tree.left = deleteFromTree(tree.left, element);
            }
            else if(element > tree.val) {
                tree.right = deleteFromTree(tree.right, element);
            }
            else {  // FUCKED UP CASE
                if(tree.left == null && tree.right == null) {
                    tree = null;
                }
                else {
                    if(tree.right==null) {  // raiz solo tiene hijo izquierdo
                        tree = tree.left;
                    }
                    else if(tree.left==null) {
                        tree = tree.right;
                    }
                    else {
                        TreeNode minElement = findMinElement(tree.right);   //Buscar el menor elemento de la raiz derecha y sustituirlo por la raiz
                        tree.val = minElement.val;
                        tree.right = deleteFromTree(tree.right, minElement.val);
                    }
                }
            }
            return tree;
        }
    }

    public TreeNode findMinElement(TreeNode tree) {
        if(tree.left == null) {
            return tree;
        }
        else {
            return findMinElement(tree.left);
        }
    }

    public void run() {
        TreeNode tree = new TreeNode(7);
        tree = insertToTree(tree, 6);
        tree = insertToTree(tree, 10);
        tree = insertToTree(tree, 8);
        tree = insertToTree(tree, 14);
        tree = insertToTree(tree, 13);
        preOrder(tree);
        System.out.println();
        tree = deleteFromTree(tree, 7);
        preOrder(tree);
    }
    public static void main(String[] args) {
        new BinarySearchTree().run();
    }
}