import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    public class AnimalQueue {
        Queue<String> dogsQueue;
        Queue<String> catsQueue;

        public AnimalQueue() {
            dogsQueue = new LinkedList<String>();
            catsQueue = new LinkedList<String>();
        }

        public void enqueue(int animal, String name) {
            if(animal == 0) {
                dogsQueue.add(name);
            }
            else {
                catsQueue.add(name);
            }
        }

        public String dequeueAny() {
            if(dogsQueue.size() > 0) {
                return dogsQueue.poll();
            }
            else {
                if(catsQueue.size() > 0) {
                    return catsQueue.poll();
                }
                else{
                    return "";
                }
            }
        }

        public String dequeueDog() {
            return dogsQueue.poll();
        }

        public String dequeueCat() {
            return catsQueue.poll();
        }
    }

    public void run() {
        AnimalQueue queue = new AnimalQueue();
        queue.enqueue(0, "tobby");   // 0 -> dog, 1 -> cat
        queue.enqueue(1, "catUgly");
        queue.enqueue(1, "catFat");
        System.out.println(queue.dequeueCat());
        System.out.println(queue.dequeueAny());
    }
    public static void main(String[] args) {
        new AnimalShelter().run();
    }
}