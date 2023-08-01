import java.util.*;

public class ImplementTrie {
    class Trie {
        // public char val;
        public boolean isWord;
        public HashMap<Character, Trie> children;

        public Trie() {
            children = new HashMap<Character, Trie>();
        }

        public void insert(String word) {
            if(word.length() == 0) return;
            char firstChar = word.charAt(0);
            Trie child;

            if(!children.containsKey(firstChar)) {
                child = new Trie();
                // child.val = firstChar;   // I think that you dont really need "val". LeetCode passes without "val"
                children.put(firstChar, child);
            }
            else {
                child = children.get(firstChar);
            }

            if(word.length() > 1) {
                child.insert(word.substring(1));
            }
            else {
                child.isWord = true;
            }
        }

        public boolean search(String word) {
            if(word.length() == 0) return false;

            char firstChar = word.charAt(0);
            if(word.length() == 1) {
                return children.containsKey(firstChar) && children.get(firstChar).isWord;
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

        public boolean startsWith(String prefix) {
            if(prefix.length() == 0) return false;
            
            char firstChar = prefix.charAt(0);
            if(prefix.length() == 1) {
                return children.containsKey(firstChar);
            }
            else {
                if(!children.containsKey(firstChar)) {
                    return false;
                }
                else {
                    return children.get(firstChar).startsWith(prefix.substring(1));
                }
            }
        }
    }

    public void run() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }

    public static void main(String[] args) {
        new ImplementTrie().run();
    }
}