//Kth Largest Element in an Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int position = start;
        int pivot = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, position, i);
                position++;
            }
        }
        swap(nums, position, end);
        if (position == k) {
            return nums[position];
        }
        
        
        if (position < k) {
            return quickSelect(nums, position + 1, end, k);
        } else {
            return quickSelect(nums, start, position - 1, k);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}