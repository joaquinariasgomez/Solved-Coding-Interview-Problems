public class WordSearch {

    public boolean findWordDFS(String word, char[][] words, boolean[][] visited, int i, int j) {
        if(i<0 || i>=words.length || j<0 || j>=words[0].length) return false;
        if(words[i][j] != word.charAt(0) || visited[i][j]) return false;
        if(word.length() == 1 && word.charAt(0) == words[i][j]) return true;

        String remainingWord = word.substring(1);
        visited[i][j] = true;
        boolean foundWord = findWordDFS(remainingWord, words, visited, i+1, j) ||
                findWordDFS(remainingWord, words, visited, i-1, j) ||
                findWordDFS(remainingWord, words, visited, i, j+1) ||
                findWordDFS(remainingWord, words, visited, i, j-1);
        visited[i][j] = false;
        return foundWord;
    }

    public boolean findWord(char[][] words, String word) {
        boolean[][] visited = new boolean[words.length][words[0].length];
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[0].length; j++) {
                if(word.charAt(0) == words[i][j] && findWordDFS(word, words, visited, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void run() {
        char[][] words = { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'E', 'S' },
                { 'A', 'D', 'E', 'E' } };
        System.out.println(findWord(words, "ABCESEEEFS"));
    }

    public static void main(String[] args) {
        new WordSearch().run();
    }
}