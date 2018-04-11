//Range Sum Query - Mutable


public class NumArray {
    class SegmentTreeNode{
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }
    
    SegmentTreeNode root = null;
    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    private SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root =  new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(nums, start, mid);
        root.right = build(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
        
    }
    
    public void update(int i, int val) {
        updateHelper(root, i, val);
    }
    
    private void updateHelper(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (i <= mid) {
            updateHelper(root.left, i, val);
        } else {
            updateHelper(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }
    
    private int sumRangeHelper(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid >= j) {
            return sumRangeHelper(root.left, i, j);
        } else if (mid < i) {
            return sumRangeHelper(root.right, i, j);
        } else {
            return sumRangeHelper(root.left, i, mid) + sumRangeHelper(root.right, mid + 1, j);
        }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */