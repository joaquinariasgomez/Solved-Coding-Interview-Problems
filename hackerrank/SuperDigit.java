public class SuperDigit {
    public int calculateSuperDigit(String n) {
        int superDigit = 0;
        for(int i=0; i<n.length(); i++) {
            superDigit += Character.getNumericValue(n.charAt(i));
        }
        return superDigit;
    }

    public int superDigit(String n, int k) {
        String p = "";
        for(int i=0; i<k; i++) {
            p += n;
        }
        
        int currentSuperDigit = calculateSuperDigit(p);
        while(currentSuperDigit >= 10) {
            currentSuperDigit = calculateSuperDigit(Integer.toString(currentSuperDigit));
        }
        return currentSuperDigit;
    }

    public void run() {
        String n = "9875";
        int k = 3;
        System.out.println(superDigit(n, k));
    }
    public static void main(String[] args) {
        new SuperDigit().run();
    }
}
