public class ReverseOnlyAlphabetical {

    public String reverseAlph(String input) {
        int length = 0;
        for(char c:input.toCharArray())
            if(Character.isAlphabetic(c))
                length++;
        char[] aux = new char[length];
        int idx = 0;
        for(int i=0; i<input.length(); i++) {
            if(Character.isAlphabetic(input.charAt(i)))
                aux[idx++] = input.charAt(i);
        }

        int begin = 0;
        int end = aux.length-1;
        while(begin < end) {
            char tmp = aux[begin];
            aux[begin] = aux[end];
            aux[end] = tmp;
            begin++;
            end--;
        }
        StringBuilder sol = new StringBuilder();
        
        int idxAux = 0;
        for(int i=0; i<input.length(); i++) {
            if(!Character.isAlphabetic(input.charAt(i))) {
                sol.append(input.charAt(i));
            }
            else {
                sol.append(aux[idxAux++]);
            }
        }

        return sol.toString();
    }

    public void run() {
        // String input = "sea!$hells3";
        String input = "b!fdceA2";
        System.out.println(reverseAlph(input));
    }
    public static void main(String[] args) {
        new ReverseOnlyAlphabetical().run();
    }
}