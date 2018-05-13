//Insert Delete GetRandom O(1)

//store(index, val) in arraylist and store(val, index) in hashmap. 
//size records the number of val inserted. 
//When remove one num, move the end to substitude the removed one.

class RandomizedSet {
    private int size;
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<Integer, Integer>();
        this.size = 0;
        this.random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, size);
            if (list.size() <= size) {
                list.add(val);
            } else {
                list.set(size, val);
            }
            size++;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val);
            size--;
            int end = list.get(size);
            if (val != end) {
                map.put(end, index);
                list.set(index, end);
            }
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(size);
        return list.get(index);
    }
}