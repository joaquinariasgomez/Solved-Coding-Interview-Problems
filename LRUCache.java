import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    class Cache {
        class ListNode {
            public int key;
            public int val;
            public ListNode next;
            public ListNode prev;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        ListNode head; // leastRecent
        ListNode tail; // mostRecent
        HashMap<Integer, ListNode> map;
        int maxSize;

        public Cache(int capacity) {
            this.maxSize = capacity;
            this.map = new HashMap<Integer, ListNode>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void insertNodeInTail(ListNode node) {
            ListNode tailPrev = tail.prev;
            tail.prev = node;
            tailPrev.next = node;
            node.prev = tailPrev;
            node.next = tail;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int sol = map.get(key).val;
                // Move key as most recently used, by removing and inserting at tail
                this.removeNode(map.get(key));
                this.insertNodeInTail(map.get(key));
                return sol;
            } else
                return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // Override key and update as MRU
                map.get(key).val = value;
                this.removeNode(map.get(key));
                this.insertNodeInTail(map.get(key));
            } else {
                if (map.size() == this.maxSize) {
                    // We need to evict first
                    ListNode nodeToRemove = head.next;
                    map.remove(nodeToRemove.key);
                    this.removeNode(nodeToRemove);
                }
                // We can safely insert at end (tail)
                ListNode newNode = new ListNode(key, value);
                this.insertNodeInTail(newNode);
                map.put(key, newNode);
            }
        }
    }

    public void run() {
        Cache cache = new Cache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(3));
    }

    public static void main(String[] args) {
        new LRUCache().run();
    }
}
