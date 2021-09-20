import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {

    class Cache {

        class ListNode {
            int key;
            int val;
            ListNode next;
            ListNode prev;
        }

        private int capacity;
        private HashMap<Integer, ListNode> map;
        private ListNode head;
        private ListNode tail;

        public Cache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<Integer, ListNode>(capacity);
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public void put(int key, int value) {
            // Put item in the front of the linked list and remove last
            ListNode node = map.get(key);
            if(node != null) {
                node.val = value;
                removeListNode(node);
                addToFrontOfListNode(node);
            }
            else {
                if(map.size() == capacity) {
                    map.remove(tail.prev.key);
                    removeListNode(tail.prev);
                }
                ListNode newNode = new ListNode();
                newNode.key = key;
                newNode.val = value;
                addToFrontOfListNode(newNode);
                map.put(key, newNode);
            }
        }

        public void addToFrontOfListNode(ListNode node) {
            ListNode headNext = head.next;
            head.next = node;
            node.next = headNext;
            node.prev = head;
            headNext.prev = node;
        }

        public void removeListNode(ListNode node) {
            ListNode next = node.next;
            ListNode prev = node.prev;
            next.prev = prev;
            prev.next = next;
        }

        public int get(int key) {
            // Put item in the front of the linked list and remove last
            ListNode node = map.get(key);
            if(node != null) {
                int result = node.val;
                removeListNode(node);
                addToFrontOfListNode(node);
                return result;
            }
            else {
                return -1;
            }
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
