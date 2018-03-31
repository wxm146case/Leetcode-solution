class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        
        for (int i = 0; i <= heights.length; i++) {
            int insert = (i == heights.length) ? 0 : heights[i];
            
            while (!stack.isEmpty() && heights[stack.peek()] >= insert) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}