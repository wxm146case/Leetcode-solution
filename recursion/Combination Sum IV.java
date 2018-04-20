//Combination Sum IV

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target + 1];
        for (int i = 0; i < count.length; i++) {
            count[i] = -1;
        }
        return helper(nums, target, count);
    }
    
    private int helper(int[] nums, int remain, int[] count) {
        if (count[remain] != -1) {
            return count[remain];
        }
        if (remain == 0) {
            return 1;
        }
        
        int res = 0;       
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= remain) {
                res += helper(nums, remain - nums[i], count);
            }
        }
        count[remain] = res;
        return res;
    }
}

public int combinationSum4(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}