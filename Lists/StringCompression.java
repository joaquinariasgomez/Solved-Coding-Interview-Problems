public class StringCompression {

    public int compressedLength(char[] array) {
        if(array == null || array.length == 0) return 0;
        if(array.length == 1) return 1;

        int i = 0;
        int writer = 0;
        while(i < array.length) {
            int j = i;
            while(j < array.length && array[i] == array[j]) {
                j++;
            }
            array[writer++] = array[i];
            if(j-i > 1) {
                String numOfCopies = Integer.toString(j-i);
                for(char c : numOfCopies.toCharArray()) {    // '1', '2' representing 12
                    array[writer++] = c;
                }
            }
            i = j;
        }
        
        return writer;
    }

    public void run() {
        char[] array = {'a', 'a', 'a', 'b'};
        System.out.println(compressedLength(array));
    }
    public static void main(String[] args) {
        new StringCompression().run();
    }
}
