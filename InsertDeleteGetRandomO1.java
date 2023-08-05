class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastElement = list.get(list.size()-1);
        list.set(idx, lastElement);
        list.remove(list.size()-1); // Remove last element -> O(1)
        map.put(lastElement, idx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rnd = new Random();
        int rndIdx = rnd.nextInt(list.size());
        return list.get(rndIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */