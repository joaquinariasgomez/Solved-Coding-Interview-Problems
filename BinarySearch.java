public class BinarySearch {
    private int findElementPos(int[] array, int element) {
        int n = array.length;
        int beg = 0;
        int end = n - 1;
        int result = -1;

        while(beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (array[mid] <= element) {
                beg = mid+1;
                result = mid;
            }
            else {
                end = mid - 1;
            }
        }

        return result;
    }

    private void run() {
        int[] array = {2, 4, 5, 7, 10, 17, 18, 20};
        System.out.println(this.findElementPos(array, 21));
    }

    public static void main(String[] args) {
        new BinarySearch().run();
    }
}
