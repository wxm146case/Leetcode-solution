//House Robber II

class Solution {
    public int rob(int[] nums) {
    if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
}
    
    private int rob1(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        
        int[][] dp = new int[nums.length][2];
        dp[start][0] = 0;
        dp[start][1] = nums[start];
        
        for (int i = start + 1; i <= end; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[end][0], dp[end][1]);
    }
}