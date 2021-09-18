import java.util.HashMap;

public class MyTrie {
    class Node {
        char value;
        boolean isWord;
        HashMap<Character, Node> children;

        public Node() {this.children = new HashMap<Character, Node>();}

        public void addWord(String word) {
            if(word==null || word.length()==0) return;

            char firstChar = word.charAt(0);

            Node child;
            if(!children.containsKey(firstChar)) {
                child = new Node();
                child.value = firstChar;
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
            System.out.println("Value: "+this.value+" isWord: "+this.isWord);
            for(HashMap.Entry<Character, Node> entry : this.children.entrySet()) {
                entry.getValue().print();
            }
        }
    }

    class Trie {
        Node root;

        public Trie(String[] words) {
            root = new Node();
            for(String word : words) {
                root.addWord(word);
            }
        }

        public boolean contains(String prefix, boolean exactMatch) {
            Node current = root;
            for(int i=0; i<prefix.length(); i++) {
                if(current.children.containsKey(prefix.charAt(i))) {
                    current = current.children.get(prefix.charAt(i));
                }
                else {
                    return false;
                }
            }

            if(exactMatch) {
                return current.isWord;
            }
            else {
                return true;
            }
        }

        public void addWords(String[] moreWords) {
            if(root == null) return;

            for(String word : moreWords) {
                root.addWord(word);
            }
        }

        public void print() {
            root.print();
        }
    }

    public void run() {
        String[] words = {"a", "ab", "hola"};
        String[] more = {"eft", "ho"};
        Trie trie = new Trie(words);
        trie.addWords(more);
        System.out.println(trie.contains("hola", true));
        trie.print();
    }

    public static void main(String[] args) {
        new MyTrie().run();
    }
}
