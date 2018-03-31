//The Skyline Problem
//"Scan across the critical points from left to right:
// When we encounter the left edge of a rectangle, we add that rectangle to the heap with its height as the key.
// When we encounter the right edge of a rectangle, we remove that rectangle from the heap.
// Any time we encounter a critical point, after updating the heap, we set the height of that critical point to the value peeked from the top of the heap.


class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings.length == 0) {
            return res;
        }
        List<int[]> heights = new ArrayList<>();
        for (int[] build : buildings) {
            heights.add(new int[]{build[0], -build[2]});
            heights.add(new int[]{build[1], build[2]});
        }
        Collections.sort(heights, new Comparator<int[]>() {
            public int compare(int[] left, int[] right) {
                if (left[0] != right[0]) {
                    return left[0] - right[0];
                }
                return left[1] - right[1];
            }
        });
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer left, Integer right) {
                return right - left;
            }
        });
        
        heap.offer(0);
        int prev = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                heap.offer(-height[1]);
            } else {
                heap.remove(height[1]);
            }
            int cur = heap.peek();
            if (prev != cur) {
                res.add(new int[]{height[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}