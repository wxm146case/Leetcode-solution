//lists中存着每个count的链表。
//保持记录min值。
//随时弹出min链表第一个
//注意最开始给1 建立一个链表。

class LFUCache {
    private HashMap<Integer, Integer> counts;
    private HashMap<Integer, Integer> vals;
    private HashMap<Integer, LinkedHashSet<Integer>> lists;
    private int min = -1;
    private int capacity;
    
    public LFUCache(int capacity) {
        counts = new HashMap<>();
        lists = new HashMap<>();
        vals = new HashMap<>();
        this.capacity = capacity;
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if (count == min && lists.get(min).size() == 0) {
            min++;
        }
        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            int del = lists.get(min).iterator().next();
            lists.get(min).remove(del);
            vals.remove(del);
            counts.remove(del);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */