import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NoPrefixSet {
    class TrieNode {
        public char data;
        public boolean isWord;
        HashMap<Character, TrieNode> children;

        public TrieNode() {this.children = new HashMap<Character, TrieNode>();}

        public void addWord(String word) {
            if(word == null || word.length() == 0) return;
            char firstChar = word.charAt(0);

            TrieNode child;
            if(!children.containsKey(firstChar)) {
                child = new TrieNode();
                child.data = firstChar;
                this.children.put(firstChar, child);
            }
            else {
                child = children.get(firstChar);
            }

            if(word.length() > 1) {
                child.addWord(word.substring(1));   // Add rest of word
            }
            else {
                child.isWord = true;
            }
        }

        public void print() {
            System.out.println("Value: " + this.data + " isWord: " + this.isWord);
            for(HashMap.Entry<Character, TrieNode> entry : this.children.entrySet()) {
                entry.getValue().print();
            }
        }

        public void printFullWords(String currentWord) {
            if(this.isWord) {
                System.out.println("Full word found: "+currentWord);
            }
            for(HashMap.Entry<Character, TrieNode> entry : this.children.entrySet()) {
                entry.getValue().printFullWords(currentWord+(entry.getValue().data));
            }
        }

        /*private void printNextWord(HashMap<Character, TrieNode> children, StringBuilder currentWord) {
            for(HashMap.Entry<Character, TrieNode> entry : children.entrySet()) {
                if(entry.getValue().isWord) {
                    System.out.println(currentWord.append(entry.getKey()).toString());
                    return;
                }
                else {
                    printNextWord(entry.getValue().children, currentWord.append(entry.getKey()));
                }
            }
        }*/
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void checkWords(String[] words) {
            for(String word : words) {
                root.addWord(word);
            }
        }

        public void print() {
            this.root.print();
        }

        public void printFullWords() {
            String currentWord = "";
            this.root.printFullWords(currentWord);
        }
    }

    public void run() {
        //List<String> words = Arrays.asList("abcd", "bcd", "abcde", "bcde");
        List<String> words = Arrays.asList("bcd", "abcd", "a");
        // Return "GOOD SET" is no string is a substring of another
        // Return "BAD SET" and the string if a substring is a substring of another
        Trie trie = new Trie();
        trie.checkWords(words.toArray(new String[words.size()]));
        trie.printFullWords();
    }

    public static void main(String[] args) {
        new NoPrefixSet().run();
    }
}
