//295. Find Median from Data Stream

class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> low;
    Queue<Integer> high;
    public MedianFinder() {
        low = new PriorityQueue<>();
        high = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare (Integer left, Integer right) {
                return right - left;
            }
        });
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        
        if(low.size() < high.size()) {
            low.add(high.poll());
        }
        
    }
    
    public double findMedian() {
        return low.size() == high.size() ? (low.peek() + high.peek()) / 2.0 : low.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */