import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {

    public int betweenTwo(List<Integer> a, List<Integer> b) {
        int total = 0;
        for(int x=1; x<=100; x++) {
            boolean ok = true;
            for(int ait=0; ait<a.size(); ait++) {
                if(x%a.get(ait)!=0) {
                    ok = false;
                }
            }
            for(int bit=0; bit<b.size(); bit++) {
                if(b.get(bit)%x!=0) {
                    ok = false;
                }
            }
            if(ok) total++;
        }
        return total;
    }

    public void run() {
        List<Integer> a = Arrays.asList(2, 6);
        List<Integer> b = Arrays.asList(24, 36);
        int n = betweenTwo(a, b);
    }
    public static void main(String[] args) {
        new BetweenTwoSets().run();
    }
}
