import java.util.Arrays;
import java.util.List;

public class GradingStudents {

    public List<Integer> getCorrectedGrades(List<Integer> grades) {
        for(int i=0; i<grades.size(); i++) {
            if(grades.get(i) >= 38) {
                int div = grades.get(i)/5;
                int remaining = grades.get(i)%5;
                if(5-remaining < 3) {
                    grades.set(i, div*5+5);
                }
            }
        }
        return grades;
    }

    public void run() {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33);
        System.out.println(getCorrectedGrades(grades));
    }
    public static void main(String[] args) {
        new GradingStudents().run();
    }
}
