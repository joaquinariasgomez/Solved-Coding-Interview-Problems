import java.util.List;

public class AppleAndOrange {
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int nApplesFallInside = 0;
        int nOrangesFallInside = 0;
        
        for(int i=0; i<apples.size(); i++) {
            int applePosition = apples.get(i)+a;
            if(applePosition >= s && applePosition <= t) {
                nApplesFallInside++;
            }
        }
        for(int i=0; i<oranges.size(); i++) {
            int orangePosition = oranges.get(i)+b;
            if(orangePosition >= s && orangePosition <= t) {
                nOrangesFallInside++;
            }
        }
        
        System.out.println(nApplesFallInside);
        System.out.println(nOrangesFallInside);
    }

}
