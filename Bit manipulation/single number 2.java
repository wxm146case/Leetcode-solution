class Solution {
    // An General Way to Handle All this sort of questions.

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                bits[i] += nums[j] >> i & 1;
            }
            bits[i] %= 3;
            res |= (bits[i] << i);
        }
        return res;
    }
}

