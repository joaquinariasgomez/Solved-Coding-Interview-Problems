public List<List<Integer>> reverse(List<List<Integer>> list) {
    List<List<Integer>> sol = new ArrayList<>();
    
    for(int i=list.size()-1; i>=0; i--) {
        sol.add(list.get(i));
    }
    
    return sol;
}

public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> sol = new ArrayList<>();
    
    if(root!=null) {
        queue.add(root);
        while(!queue.isEmpty()) {
            int currSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            
            for(int i=0; i<currSize; i++) {
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            sol.add(currLevel);
        }
    }
    
    return reverse(sol);
}
