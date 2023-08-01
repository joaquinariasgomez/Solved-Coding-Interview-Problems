import java.util.*;

public class WordSearch2 {

    class TrieNode {
        public boolean isWord;
        public char val;
        public HashMap<Character, TrieNode> children;    

        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
        }

        public void addWord(String word) {
            if(word.length() == 0) return;
            char firstChar = word.charAt(0);
            TrieNode child;

            if(!children.containsKey(firstChar)) {
                child = new TrieNode();
                child.val = firstChar;
                children.put(firstChar, child);
            }
            else {
                child = children.get(firstChar);
            }

            if(word.length() > 1) { // Add rest of word
                child.addWord(word.substring(1));
            }
            else {
                child.isWord = true;
            }
        }

        public void removeWord(String word) {
            if(word.length() == 0) return;
            char firstChar = word.charAt(0);

            if(children.containsKey(firstChar)) {
                children.get(firstChar).removeWord(word.substring(1));
                children.get(firstChar).isWord = false;
                if(children.get(firstChar).children.size() == 0) {
                    children.remove(firstChar);
                }
            }
        }

        public void print() {
            System.out.println("Value: " + this.val + " isWord: " + this.isWord);
            for (HashMap.Entry<Character, TrieNode> entry : this.children.entrySet()) {
                entry.getValue().print();
            }
        }
    }

    public void fillSolWordsDFS(char[][] board, boolean[][] visited, TrieNode root, TrieNode node, List<String> sol, int i, int j, String currWord) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || !node.children.containsKey(board[i][j])) return;
        visited[i][j] = true;
        currWord += board[i][j];
        node = node.children.get(board[i][j]);
        if(node.isWord) {
            sol.add(currWord);
            root.removeWord(currWord);
        }
        fillSolWordsDFS(board, visited, root, node, sol, i+1, j, currWord);
        fillSolWordsDFS(board, visited, root, node, sol, i-1, j, currWord);
        fillSolWordsDFS(board, visited, root, node, sol, i, j+1, currWord);
        fillSolWordsDFS(board, visited, root, node, sol, i, j-1, currWord);
        visited[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> sol = new ArrayList<String>();
        TrieNode trie = new TrieNode();
        for(String word : words) {
            trie.addWord(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                fillSolWordsDFS(board, visited, trie, trie, sol, i, j, "");
            }
        }
        return sol;
    }

    public void run() {
        char[][] board = { { 'o', 'a', 'a', 'n' },
                            { 'e', 't', 'a', 'e' },
                            { 'i', 'h', 'k', 'r' },
                            { 'i', 'f', 'l', 'v' } };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> found = findWords(board, words);
        for(String foundWord : found) {
            System.out.println(foundWord);
        }
    }
    public static void main(String[] args) {
        new WordSearch2().run();
    }
}