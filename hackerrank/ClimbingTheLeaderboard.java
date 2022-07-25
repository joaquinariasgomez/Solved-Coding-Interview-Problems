import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingTheLeaderboard {
    class Node {
        public Node(int score, int position) {
            this.score = score;
            this.position = position;
        }
        int score;
        int position;
    }

    public List<Integer> getPuntuation(List<Integer> ranked, List<Integer> player) {
        Node[] structure = new Node[ranked.size()];
        List<Integer> sol = new ArrayList<>();
        int currentPosition = 1;
        structure[0] = new Node(ranked.get(0), currentPosition);
        for(int i=1; i<ranked.size(); i++) {
            if(ranked.get(i) < ranked.get(i-1)) {
                currentPosition++;
            }
            structure[i] = new Node(ranked.get(i), currentPosition);
        }
        
        // Now binary search for every player
        for(int play : player) {
            //... time for binary search the structure
            int begin = 0;
            int end = structure.length-1;
            int playerPosition = 1;
            while(begin <= end) {
                int mid = begin + (end-begin)/2;
                if(structure[mid].score > play) {
                    playerPosition = structure[mid].position + 1;
                    begin = mid + 1;
                }
                else {
                    playerPosition = structure[mid].position;
                    end = mid - 1;
                }
            }
            sol.add(playerPosition);
        }

        return sol;
    }

    public void run() {
        List<Integer> ranked = Arrays.asList(100, 90, 90, 80);
        List<Integer> player = Arrays.asList(70, 80, 105);

        List<Integer> puntuations = getPuntuation(ranked, player);
        for(int e : puntuations) {
            System.out.print(e+" ");
        }
    }

    public static void main(String[] args) {
        new ClimbingTheLeaderboard().run();
    }
}
