public class PermMissingElem {

    private int missingElem(int[] array) {
        int currentSum = 0;
        float arraySize = array.length + 1;
        int theoreticalSum = (int)((arraySize * (arraySize + 1)) / 2);
        for(int a : array) {
            currentSum += a;
        }
        return theoreticalSum - currentSum;
    }

    private void run() {
        int[] array = {2, 1, 3, 5};
        System.out.println(missingElem(array));
    }

    public static void main(String[] args) {
        new PermMissingElem().run();
    }
}
