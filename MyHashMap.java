public class MyHashMap {
    class LinkedList {
        public int key;
        public int val;
        public LinkedList next;
        public LinkedList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    LinkedList[] map;
    static int maxSize = 1000;

    public MyHashMap() {
        map = new LinkedList[maxSize];
        for(int i=0; i<map.length; i++)
            map[i] = new LinkedList(-1, -1);
    }

    public int getHash(int key) {
        return key%maxSize;
    }
    
    public void put(int key, int value) {
        int idx = getHash(key);
        LinkedList curr = map[idx];
        while(curr.next != null) {
            if(curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new LinkedList(key, value);
    }
    
    public int get(int key) {
        int idx = getHash(key);
        LinkedList curr = map[idx].next;
        while(curr != null) {
            if(curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = getHash(key);
        LinkedList curr = map[idx];
        while(curr != null && curr.next != null) {
            if(curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */