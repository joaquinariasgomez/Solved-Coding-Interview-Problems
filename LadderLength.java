import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        
        queue.add(beginWord);
        while(!queue.isEmpty()) {
            String currentWord = queue.poll();
            System.out.println(currentWord);
            pushAdjacents(currentWord, wordList, queue);
        }
        return 0;
    }
    
    public void pushAdjacents(String currentWord, List<String> wordList, Queue<String> queue) {
        for(String word : wordList) {
            if(isChangedOneLetter(currentWord, word)) {
                queue.add(word);
            }
        }
    }
    
    public boolean isChangedOneLetter(String beginWord, String endWord) {
        char[] first = beginWord.toCharArray();
        char[] second = endWord.toCharArray();
        int difference = 0;
        
        if(first.length != second.length) {
            return false;
        }
        for(int i=0; i<first.length; i++) {
            if(first[i]!=second[i]) {
                if(difference > 0) {
                    return false;
                }
                else {
                    difference++;
                }
            }
        }
        return true;
    }

    public void run() {
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        ladderLength("hit", "cog", wordList);
    }
    public static void main(String[] args) {
        new LadderLength().run();
    }
}
