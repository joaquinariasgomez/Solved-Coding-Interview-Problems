public class LongestTurbulentSubarray {

    public int getmaxLengthSubarray(int[] array) {
        int left = 0;
        int right = 1;
        int max = 1;
        char lastEq = ' ';

        while(right < array.length) {
            if(array[right-1] > array[right] && lastEq!='>') {
                max = Math.max(max, right - left + 1);
                right++;
                lastEq = '>';
            }
            else if(array[right-1] < array[right] && lastEq!='<') {
                max = Math.max(max, right - left + 1);
                right++;
                lastEq = '<';
            } else {
                if(array[right] == array[right-1]) {
                    right++;
                }
                left = right - 1;
                lastEq = ' ';
            }
        }
        return max;
    }

    public void run() {
        int[] array = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
        System.out.println(getmaxLengthSubarray(array));
    }

    public static void main(String[] args) {
        new LongestTurbulentSubarray().run();
    }
}