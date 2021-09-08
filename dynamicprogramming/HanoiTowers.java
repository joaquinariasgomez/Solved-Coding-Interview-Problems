import java.util.Stack;

public class HanoiTowers {

    public void visualize(Stack<Character> tower) {
        for(char c : tower) {
            System.out.println(c);
        }
    }

    public Stack<Character> getCopy(Stack<Character> tower) {
        Stack<Character> aux = new Stack<Character>();
        Stack<Character> result = new Stack<Character>();

        while(tower.size() > 0) {
            char element = tower.pop();
            if(tower.size() == 0) { // Move to result (Last tower)
                result.push(element);
            }
            else {                  // Move to aux (Middle tower)
                aux.push(element);
            }
        }
        while(aux.size() > 0) { // Move every element to result (Last tower)
            char element = aux.pop();
            result.push(element);
        }
        return result;
    }

    public void run() {
        Stack<Character> tower = new Stack<Character>();
        tower.push('d');
        tower.push('c');
        tower.push('b');
        tower.push('a');
        Stack<Character> newTower = getCopy(tower);
        visualize(newTower);
    }
    public static void main(String[] args) {
        new HanoiTowers().run();
    }
}
