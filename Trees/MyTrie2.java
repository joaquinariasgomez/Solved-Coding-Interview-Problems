import java.util.HashMap;

public class MyTrie2 {
    class Node {
        boolean isWord;
        HashMap<Character, Node> map;

        public Node() {
            map = new HashMap<Character, Node>();
            isWord = false;
        }

        public void addWord(String word) {
            if(word == null || word.length() == 0) return;
            char currentChar = word.charAt(0);

            Node child;
            if(map.containsKey(currentChar)) {
                child = map.get(currentChar);
            }
            else {
                child = new Node();
                map.put(currentChar, child);
            }

            if(word.length() > 1) {
                child.addWord(word.substring(1));
            }
            else {
                child.isWord = true;
            }
        }
    }

    public void printWords(Node head, String currWord) {
        if(head.map.size() == 0)  {
            System.out.println(currWord);
        }
        else {
            if(head.isWord) {
                System.out.println(currWord);
            }
            for(HashMap.Entry<Character, Node> entry : head.map.entrySet()) {
                printWords(entry.getValue(), currWord+entry.getKey());
            }
        }
    }

    public void run() {
        Node root = new Node();
        root.addWord("word");
        root.addWord("pen");
        root.addWord("woo");
        root.addWord("pe");
        printWords(root, "");
    }

    public static void main(String[] args) {
        new MyTrie2().run();
    }
}
