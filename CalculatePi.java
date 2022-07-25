import java.util.Random;

public class CalculatePi {

    public double distanceToCenter(double px, double py) {
        return Math.sqrt(px*px + py*py);
    }

    public double calculatePi() {
        Random random = new Random();
        int nInstances = 1000000;
        int closeToCenterCounter = 0;
        for(int i=0; i<nInstances; i++) {
            double px = random.nextDouble();
            double py = random.nextDouble();

            if(distanceToCenter(px, py) <= 1) {
                ++closeToCenterCounter;
            }
        }
        return (double)closeToCenterCounter/(double)nInstances * 4;
    }

    public void run() {
        System.out.println(calculatePi());
    }
    public static void main(String[] args) {
        new CalculatePi().run();
    }
}