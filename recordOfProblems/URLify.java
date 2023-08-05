public class URLify {

    public String convert(String input, int size) {
        char[] sol = new char[size];
        int r = 0;

        for(int i=0; i<size; i++) {
            char currentChar = input.charAt(r);
            if(currentChar != ' ') {
                sol[i] = currentChar;
            }
            else {
                sol[i++] = '%';
                sol[i++] = '2';
                sol[i] = '0';
            }
            r++;
        }
        return new String(sol);
    }

    public void run() {
        String input = "a b  ";
        int size = 5;
        System.out.println(convert(input, size));
    }
    public static void main(String[] args) {
        new URLify().run();
    }
}