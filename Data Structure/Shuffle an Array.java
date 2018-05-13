//384. Shuffle an Array
//get a random index, exchange i and ranom index, from 0 - length-1;

class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] rand = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length);
            int temp = rand[i];
            rand[i] = rand[index];
            rand[index] = temp;
        }
        return rand;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */