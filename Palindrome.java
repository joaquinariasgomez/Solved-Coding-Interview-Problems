public class Palindrome {

    private String palindrome(String s) {
        char[] array = s.toCharArray();
        int pBegin = 0;
        int pEnd = array.length - 1;

        while(pBegin < pEnd) {
            if(array[pBegin] == '?' && array[pEnd] == '?') {
                array[pBegin] = 'a';
                array[pEnd] = 'a';
            }
            else {
                if(array[pBegin] == '?' && array[pEnd] != '?') {
                    array[pBegin] = array[pEnd];
                }
                else {
                    if(array[pBegin] != '?' && array[pEnd] == '?') {
                        array[pEnd] = array[pBegin];
                    }
                    else {
                        if(array[pBegin] != '?' && array[pEnd] != '?' && array[pBegin] != array[pEnd]) {
                            return "NO";
                        }
                    }
                }
            }
            pBegin++;
            pEnd--;
        }
        return new String(array);
    }

    private void run() {
        String s = "?a??";
        System.out.println(palindrome(s));
    }

    public static void main(String[] args) {
        new Palindrome().run();
    }
}
