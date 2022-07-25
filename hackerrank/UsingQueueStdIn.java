import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UsingQueueStdIn {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int q = keyboard.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>(); 
        
        for(int i=0; i<q; i++) {
            int query = keyboard.nextInt();
            if(query == 1) {
                int element = keyboard.nextInt();
                queue.add(element);
            }
            else if(query == 2) { // Dequeue
                queue.poll();
            }
            else {  // Print front of queue
                System.out.println(queue.peek());
            }
        }
        keyboard.close();
    }
}
