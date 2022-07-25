import java.util.Arrays;
import java.util.List;

public class MinimumBribes {

    public void minimumBribes(List<Integer> q) {
        int bribes = 0;
        for(int i=0; i<q.size(); i++) {
            if(q.get(i) - (i+1) > 2) {
                System.out.println("Too chaotic"); return;
            }
            for(int j=i+1; j<i+100 && j<q.size(); j++) {
                if(q.get(j) < q.get(i)) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    public void run() {
        List<Integer> queue = Arrays.asList(2, 1, 5, 3, 4);
        minimumBribes(queue);
    }
    public static void main(String[] args) {
        new MinimumBribes().run();
    }
}
