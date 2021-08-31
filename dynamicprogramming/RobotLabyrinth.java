import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class RobotLabyrinth {

    class Point {
        int x, y;
        public Point(int x, int y) {this.x=x; this.y=y;}
    }

    public boolean isValid(Point current, boolean[][] obstacles) {
        return current.x >= 0 && current.y >= 0 && current.x < obstacles.length && current.y < obstacles[0].length;
    }

    // BRUTE FORCE SOLUTION: O(2^n)
    // Dynamic programming solution (with failedPoints HashSet): O(n)
    public boolean isPath(boolean[][] obstacles, Point current, List<Point> path, HashSet<Point> failedPoints) {
        if(current.x == 0 && current.y == 0) {
            path.add(current);
            return true;
        }
        if(!isValid(current, obstacles) || failedPoints.contains(current)) {
            return false;
        }
        if(obstacles[current.x][current.y]) {
            failedPoints.add(current);
            return false;
        }
        else {
            if(isPath(obstacles, new Point(current.x-1, current.y), path, failedPoints)
            || isPath(obstacles, new Point(current.x, current.y-1), path, failedPoints)) {
                path.add(current);
                return true;
            }
            else  {
                failedPoints.add(current);
                return false;
            }
        }
    }

    public void run() {
        Point start = new Point(4,4);
        boolean[][] obstacles = {
            {false, false, true, false, true},
            {false, false, true, false, true},
            {false, true, false, false, true},
            {false, false, true, false, true},
            {true, false, false, false, false}
        };
        List<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        boolean pathExists = isPath(obstacles, start, path, failedPoints);
        System.out.println(pathExists);
        for(Point p : path) {
            System.out.println(p.x+" "+p.y);
        }
    }
    public static void main(String[] args) {
        new RobotLabyrinth().run();
    }
}
