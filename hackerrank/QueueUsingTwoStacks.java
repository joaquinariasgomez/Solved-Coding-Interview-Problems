import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int q = keyboard.nextInt();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        
        for(int i=0; i<q; i++) {
            int query = keyboard.nextInt();
            if(query == 1) {
                int element = keyboard.nextInt();
                // Push element into stack
                // Push everything to stack2
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                stack1.push(element);
                // Push everything back to stack1
                while(!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            else if(query == 2) { // Dequeue
                stack1.pop();
            }
            else {  // Print front of queue
                System.out.println(stack1.peek());
            }
        }
        keyboard.close();
    }
}
