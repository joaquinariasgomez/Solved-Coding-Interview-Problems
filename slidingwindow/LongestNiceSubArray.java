public class LongestNiceSubArray {

    public int longestNice(int[] array) {
        int and = 0;
        int longest = 0;
        int begin = 0;
        for(int end = 0; end < array.length; end++) {
            while((array[end] & and) > 0) {
                and ^= array[begin++];
            }
            and |= array[end];
            longest = Math.max(longest, end-begin+1);
        }
        return longest;
    }

    public void run() {
        int[] array = {1, 3, 8, 48, 9};
        System.out.println(longestNice(array));
    }
    public static void main(String[] args) {
    new LongestNiceSubArray().run();
    }
}