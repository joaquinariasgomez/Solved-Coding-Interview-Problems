import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public void fillPermutation(List<String> sol, List<Character> input, StringBuilder currentPerm, int currentIndex) {
        if(currentIndex == input.size()) {
            sol.add(currentPerm.toString());
            return;
        }
        if(Character.isDigit(input.get(currentIndex))) {
            fillPermutation(sol, input, currentPerm, currentIndex+1);
        }
        else {
            currentPerm.setCharAt(currentIndex, Character.toLowerCase(input.get(currentIndex)));
            fillPermutation(sol, input, currentPerm, currentIndex+1);
            currentPerm.setCharAt(currentIndex, Character.toUpperCase(input.get(currentIndex)));
            fillPermutation(sol, input, currentPerm, currentIndex+1);
        }
    }

    public void run() {
        String input = "a1b2c3d4";
        // String input = "3z4";
        List<String> sol = new ArrayList<String>();
        List<Character> inputList = new ArrayList<Character>();
        for(int i=0; i<input.length(); i++) {
            inputList.add(input.charAt(i));
        }

        fillPermutation(sol, inputList, new StringBuilder(input), 0);
        System.out.println(sol);
    }
    public static void main(String[] args) {
        new LetterCasePermutation().run();
    }
}

// class Solution {
//     public List<String> letterCasePermutation(String s) {
//         StringBuilder currentPerm = new StringBuilder(s);
//         int currentIndex = 0;
//         List<String> sol = new ArrayList<String>();
        
//         fillSol(sol, currentPerm, currentIndex, s);
//         return sol;
//     }
    
//     void fillSol(List<String> sol, StringBuilder currentPerm, int currentIndex, String s) {
//         if(currentIndex == s.length()) {
//             sol.add(currentPerm.toString());
//             return;
//         }
//         if(Character.isDigit(s.charAt(currentIndex))) {
//             fillSol(sol, currentPerm, currentIndex+1, s);
//         }
//         else {
//             currentPerm.setCharAt(currentIndex, Character.toLowerCase(s.charAt(currentIndex)));
//             fillSol(sol, currentPerm, currentIndex+1, s);
//             currentPerm.setCharAt(currentIndex, Character.toUpperCase(s.charAt(currentIndex)));
//             fillSol(sol, currentPerm, currentIndex+1, s);
//         }
//     }
// }