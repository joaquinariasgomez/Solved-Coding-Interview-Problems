class MyHashSet {

    class LinkedList {
        int key;
        LinkedList next;
        public LinkedList(int key) {
            this.key = key;
        }
    }

    LinkedList[] set;
    static int maxSize = 1000;

    public MyHashSet() {
        set = new LinkedList[maxSize];
        for(int i=0; i<set.length; i++)
            set[i] = new LinkedList(-1);
    }

    public int getHash(int key) {
        return key%maxSize;
    }
    
    public void add(int key) {
        int idx = getHash(key);
        LinkedList curr = set[idx];
        while(curr.next != null) {
            if(curr.next.key == key) {
                return;
            }
            curr = curr.next;
        }
        curr.next = new LinkedList(key);
    }
    
    public void remove(int key) {
        int idx = getHash(key);
        LinkedList curr = set[idx];
        while(curr.next != null) {
            if(curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int idx = getHash(key);
        LinkedList curr = set[idx];
        while(curr.next != null) {
            if(curr.next.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */