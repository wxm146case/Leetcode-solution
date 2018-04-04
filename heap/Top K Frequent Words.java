//Top K Frequent Words

class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Queue<String> heap = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String left, String right) {
                if (map.get(left) != map.get(right)) {
                    return map.get(left) - map.get(right);
                } else {
                    return right.compareTo(left);
                }
            }
        });
        
        for (String word : map.keySet()) {
            if (heap.size() < k) {
                heap.add(word);
            } else {
                heap.add(word);
                heap.poll();           
            }
        }
        List<String> res = new ArrayList<>();
        while (heap.size() != 0) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}