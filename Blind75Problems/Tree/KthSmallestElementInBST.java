import java.util.List;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {  // O(n) time, O(k) memory, just stores first k elements
        List<Integer> inorderList = new ArrayList<Integer>();
        fillInorder(root, inorderList, k);
        return inorderList.get(k-1);
    }

    public void fillInorder(TreeNode root, List<Integer> inorderList, int k) {
        if(root != null && inorderList.size() < k) {
            fillInorder(root.left, inorderList);
            inorderList.add(root.val);
            fillInorder(root.right, inorderList);
        }
    }

    public void run() {

    }
    public static void main(String[] args) {
        new KthSmallestElementInBST().run();
    }
}