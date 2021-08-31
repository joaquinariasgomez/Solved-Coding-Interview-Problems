public class ReverseString {

    private String reverse(String input) {
        char[] array = input.toCharArray();
        String reverseArray = "";

        int p1 = 0;
        int p2 = array.length - 1;

        while(p1<p2) {
            char p1Element = array[p1];
            array[p1] = array[p2];
            array[p2] = p1Element;

            p1++;
            p2--;
        }

        for(int i=0; i<array.length; ++i) {
            reverseArray += array[i];
        }

        return reverseArray;
    }

    private void run() {
        String array = "abc";
        System.out.println(reverse(array));
    }
    public static void main(String[] args) {
        new ReverseString().run();
    }
}
