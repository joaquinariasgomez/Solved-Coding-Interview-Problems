import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int currNode, List<List<Integer>> adj, HashSet<Integer> seen) {
        if(seen.contains(currNode)) {
            return false;
        }
        if(adj.get(currNode).isEmpty()) return true;   // This course can be completed for sure
        seen.add(currNode);
        for(int neighbor : adj.get(currNode)) {
            if(!canFinish(neighbor, adj, seen)) {
                return false;
            }
        }
        seen.remove(currNode);
        adj.set(currNode, new ArrayList<Integer>());
        return true;
    } 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        HashSet<Integer> seen = new HashSet<Integer>();
        for(int currCourse = 0; currCourse < numCourses; currCourse++) {
            if(!canFinish(currCourse, adj, seen)) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        int numCourses = 5;
        int[][] prerequisites = new int[4][2];
        prerequisites[0] = new int[]{1, 4};
        prerequisites[1] = new int[]{2, 4};
        prerequisites[2] = new int[]{3, 1};
        prerequisites[3] = new int[]{3, 2};
        System.out.println(canFinish(numCourses, prerequisites));
    }
    public static void main(String[] args) {
        new CourseSchedule().run();
    }
}