import java.lang.Math;

public class FrogJump {

    private int minJumps(int x, int y, int d) {
        int jumps = 0;
        int currentDistance = x;
        while(currentDistance < y) {
            currentDistance += d;
            jumps++;
        }
        return jumps;
    }

    private double minJumps2(int x, int y, int d) {
        return Math.ceil((double)(y-x) / (double)d);
    }

    private void run() {
        int x = 10;
        int y = 85;
        int d = 30;
        System.out.println(this.minJumps2(x, y, d));
    }

    public static void main(String[] args) {
        new FrogJump().run();
    }
}
