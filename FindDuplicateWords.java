import java.util.HashSet;

public class FindDuplicateWords {

    public String getDuplicateWord(String input) {
        HashSet<String> set = new HashSet<String>();
        String[] words = input.toLowerCase().split(" ");
        for(String word : words) {
            if(set.contains(word)) {
                return word;
            }
            else {
                set.add(word);
            }
        }
        return "";
    }

    public void run() {
        String input = "The dog is the best";
        System.out.println(getDuplicateWord(input));
    }
    public static void main(String[] args) {
        new FindDuplicateWords().run();
    }
}