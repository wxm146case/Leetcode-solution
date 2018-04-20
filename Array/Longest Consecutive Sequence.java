//Longest Consecutive Sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;
        for (Integer num : nums) {
            set.add(num);
        }
        for (Integer num : nums) {
            if (!set.contains(num)) {
                continue;
            }
            int length = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.addLast(num);
            set.remove(num);
            while(!queue.isEmpty()) {
                int cur = queue.pollFirst();
                length++;
                if (set.contains(cur + 1)) {
                    queue.addLast(cur + 1);
                    set.remove(cur + 1);
                }
                if (set.contains(cur - 1)) {
                    queue.addLast(cur - 1);
                    set.remove(cur - 1);
                }
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}