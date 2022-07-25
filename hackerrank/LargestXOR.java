public class LargestXOR {

    public String findYvalue(int bits, int maxSet, String x) {
        String sol = x;
        sol = sol.replace('0', '&');
        sol = sol.replace('1', '0');
        sol = sol.replace('&', '1');
        String firstPart = "";
        int index = 0;
        while(maxSet > 0) {
            if(x.charAt(index) == '0') {
                firstPart += "1";
                maxSet--;
            }
            else {
                firstPart += "0";
            }
            index++;
        }
        if(firstPart.length() < sol.length()) {
            sol = firstPart + sol.substring(firstPart.length());
        }
        return sol;
    }

    public void run() {
        String test = "101";
        System.out.println(findYvalue(3, 1, test));
    }
    public static void main(String[] args) {
        new LargestXOR().run();
    }
}
