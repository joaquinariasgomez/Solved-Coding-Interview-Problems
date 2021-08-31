public class MinimumDeletionCost {

    private int minimumDeletionCost(String s, int[] c) {
        int deletionCost = 0;
        if(s.length() <= 1) return deletionCost;
        char[] array = s.toCharArray();

        char currentChar = array[0];
        char lastChar = array[0];
        for(int i=1; i<array.length; ++i) {
            lastChar = array[i-1];
            currentChar = array[i];
            if(currentChar == lastChar) {
                deletionCost += Math.min(c[i-1], c[i]);
            }
        }
        return deletionCost;
    }


    private void run() {
        String s = "a";
        int[] c = {0, 1, 2, 4, 3, 5};
        System.out.println(minimumDeletionCost(s, c));
    }
    public static void main(String[] args) {
        new MinimumDeletionCost().run();
    }
}
