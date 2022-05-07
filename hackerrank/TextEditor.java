import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

    public void run() {
        Scanner keyboard = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        Stack<String> states = new Stack<String>();
        states.push("");
        
        int nOperations = keyboard.nextInt();
        keyboard.nextLine();
        for(int i=0; i<nOperations; i++) {
            int operation = keyboard.nextInt();
            switch(operation) {
                case 1: 
                          s.append(keyboard.next());
                          states.push(s.toString());
                          break;
                case 2: 
                          s.delete(s.length()-keyboard.nextInt(), s.length());
                          states.push(s.toString());
                          break;
                case 3:   System.out.println(s.charAt(keyboard.nextInt()-1));
                          break;
                case 4: if(!states.isEmpty()) {
                            states.pop();
                            s = new StringBuilder(states.peek());
                            }
                          break;
            }
        }
        
        keyboard.close();
    }

    public static void main(String[] args) {
        new TextEditor().run();
    }
}
