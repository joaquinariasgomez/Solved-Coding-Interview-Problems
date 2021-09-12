import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {

    class Cache {
        private int capacity;
        private Queue<Integer> queue;   //Keys of map
        HashMap<Integer, Integer> map;

        public Cache(int capacity) {
            this.capacity = capacity;
            this.queue = new LinkedList<Integer>();
            this.map = new HashMap<Integer, Integer>(capacity);
        }

        public void put(int key, int value) {
            if(map.size() == capacity) {
                map.remove(getFrontKey());
            }
            map.put(key, value);
            queue.add(key);
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            else {
                int result = map.get(key);
                // Queue remove key
                // Queue add key
                return result;
            }
        }

        public int getFrontKey() {
            return queue.poll();
        }
    }

    public void run() {
        Cache cache = new Cache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(1));
    }
    public static void main(String[] args) {
        new LRUCache().run();
    }
}
