public class OneWay {

    public boolean areOneWay(String input1, String input2) {
        if(Math.abs(input1.length() - input2.length()) > 1) return false;
        int diff = 0;
        int p1 = 0;
        int p2 = 0;

        while(p1 < input1.length() && p2 < input2.length()) {
            char currentChar1 = input1.charAt(p1);
            char currentChar2 = input2.charAt(p2);
            if(currentChar1 != currentChar2) {
                diff++;
                if(input1.length() == input2.length()) {
                    p1++;
                    p2++;
                }
                else {
                    if(input1.length() > input2.length()) {
                        p1++;
                    }
                    else {
                        p2++;
                    }
                }
            }
            else {
                p1++;
                p2++;
            }
        }
        return diff <= 1;
    }

    public void run() {
        String input1 = "pale";
        String input2 = "palel";
        System.out.println(areOneWay(input1, input2));
    }
    public static void main(String[] args) {
        new OneWay().run();
    }
}