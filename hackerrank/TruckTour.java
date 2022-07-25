import java.util.List;
import java.util.Arrays;

public class TruckTour {
    public int truckTour(List<List<Integer>> petrolpumps) {
        int startPoint = 0;
        int current = 0;

        for(int i=0; i<petrolpumps.size(); i++) {
            int extraPetrol = petrolpumps.get(i).get(0);
            int extraDistance = petrolpumps.get(i).get(1);
            
            if(current + extraPetrol >= extraDistance) {
                current += extraPetrol - extraDistance;
            }
            else {
                startPoint = i+1;
                current = 0;
            }
        }
        return startPoint;
    }

    public void run() {
        List<List<Integer>> stations = Arrays.asList(Arrays.asList(1, 5),
                                                     Arrays.asList(10, 3),
                                                     Arrays.asList(1, 17),
                                                     Arrays.asList(3, 2));
        System.out.println(truckTour(stations));
    }
    public static void main(String[] args) {
        new TruckTour().run();
    }
}
