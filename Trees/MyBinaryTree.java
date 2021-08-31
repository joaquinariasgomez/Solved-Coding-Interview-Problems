class Node {
  public int value;
  Node left, right;
  public Node(int value) {
    this.value = value;
    left = right = null;
  }
}

class BinaryTree {
  public Node root;

  public BinaryTree(int value) {
    root = new Node(value);
  }
  public BinaryTree() {
    root = null;
  }

  public Node insertLeft(int item) {
    root.left = new Node(item);
    return root.left;
  }

  public Node insertRight(int item) {
    root.right = new Node(item);
    return root.right;
  }
  public boolean isEmpty() {return root == null;}
}

public class MyBinaryTree {

  public static void printInorder(Node root) {
    if(root != null) {
      printInorder(root.left);
      System.out.println(root.value);
      printInorder(root.right);
    }
  }

  public static void inverseBinaryTree(Node root) {
    if(root != null) {
      Node aux = root.left;
      root.left = root.right;
      root.right = aux;
      inverseBinaryTree(root.left);
      inverseBinaryTree(root.right);
    }
  }

  public static boolean areEqualTrees(Node root1, Node root2) {
    if(root1 != null && root2 != null) {
      return (root1.value == root2.value && (areEqualTrees(root1.left, root2.left) && areEqualTrees(root1.right, root2.right)));
    }
    else {
      if(root1 == null && root2 == null) {
        return true;
      }
      else {
        return false;
      } 
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(1);
    tree.insertLeft(2).left = new Node(4);
    tree.insertRight(3);

    BinaryTree tree2 = new BinaryTree(1);
    tree2.insertLeft(2).left = new Node(4);
    tree2.insertRight(3);

    System.out.println();
    //inverseBinaryTree(tree.root);
    boolean equalTrees = areEqualTrees(tree.root, tree2.root);
    System.out.println(equalTrees);
  }
}