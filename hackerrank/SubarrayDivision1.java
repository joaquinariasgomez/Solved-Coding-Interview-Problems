import java.util.Arrays;
import java.util.List;

public class SubarrayDivision1 {

    public int birthday(List<Integer> s, int d, int m) {
        int begin = 0;
        int end = m-1;
        int currentSum = 0;
        for(int i=begin; i<=end; i++) {
            currentSum += s.get(i);
        }
        int sol = 0;
        
        while(end<s.size()) {
            if(currentSum == d) {
                sol++;
            }
            currentSum -= s.get(begin);
            if(end+1<s.size()) currentSum += s.get(end+1);
            begin++;
            end++;
        }
        
        return sol;
    }

    public void run() {
        List<Integer> s = Arrays.asList(2, 2, 1, 3, 2);
        int d = 4;
        int m = 2;
        System.out.println(birthday(s, d, m));
    }
    public static void main(String[] args) {
        new SubarrayDivision1().run();
    }
}
