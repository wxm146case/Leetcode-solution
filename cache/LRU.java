class LRUCache {
    //use HashMap to finish O(1) find;
    //use LinkedList to finish O(1) remove and add;
    class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }
    private Node dummy = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private HashMap<Integer, Node> map;
    private int capacity;


    public LRUCache(int capacity) {
        dummy.next = tail;
        tail.prev = dummy;
        map = new HashMap<>();
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node current = map.get(key);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            move_to_end(current);
            return current.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        } 
        
        if (map.size() == capacity) {
            map.remove(dummy.next.key);
            dummy.next = dummy.next.next;
            dummy.next.prev = dummy;
        }
        
        Node cur = new Node(key, value);
        map.put(key, cur);
        move_to_end(cur);
        
    }
    
    private void move_to_end(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */