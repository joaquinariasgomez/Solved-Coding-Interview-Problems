public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> solution = new LinkedList<>();
    
    if(root != null) {
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                TreeNode current = queue.poll();
                //Process node:
                currentLevel.add(current.val);
                //Add childs
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            solution.add(currentLevel);
        }
    }
    
    return solution;
}
