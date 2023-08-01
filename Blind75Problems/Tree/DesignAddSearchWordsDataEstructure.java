import java.util.*;

public class DesignAddSearchWordsDataEstructure {

    class WordDictionary {
        public char val;
        public boolean isWord;
        public HashMap<Character, WordDictionary> children;

        public WordDictionary() {
            children = new HashMap<Character, WordDictionary>();
        }

        public void addWord(String word) {
            if(word.length() == 0) return;
            char firstChar = word.charAt(0);
            WordDictionary child;

            if(!children.containsKey(firstChar)) {
                child = new WordDictionary();
                child.val = firstChar;
                children.put(firstChar, child);
            }
            else {
                child = children.get(firstChar);
            }

            if(word.length() > 1) {
                child.addWord(word.substring(1));
            }
            else {
                child.isWord = true;
            }
        }

        public boolean search(String word) {
            if(word.length() == 0) return false;

            char firstChar = word.charAt(0);
            if(word.length() == 1) {
                if(children.containsKey(firstChar) && children.get(firstChar).isWord) return true;
                if(word.equals(".")) {
                    boolean result = false;
                    for(Map.Entry<Character, WordDictionary> entry : children.entrySet()) {
                        result = result || entry.getValue().isWord;
                    }
                    return result;
                }
                else {
                    return false;
                }
            }

            if(firstChar == '.') {
                boolean result = false;
                for(Map.Entry<Character, WordDictionary> entry : children.entrySet()) {
                    result = result || entry.getValue().search(word.substring(1));
                }
                return result;
            }
            else {
                if(!children.containsKey(firstChar)) {
                    return false;
                }
                else {
                    return children.get(firstChar).search(word.substring(1));
                }
            }
        }
    }

    public void run() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }

    public static void main(String[] args) {
        new DesignAddSearchWordsDataEstructure().run();
    }
}