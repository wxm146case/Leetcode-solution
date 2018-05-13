//Longest Increasing Path in a Matrix 

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int[][] memo = new int[matrix.length][matrix[0].length];
        int[][] visited = new int[matrix.length][matrix[0].length];
        
        int res = 1;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, helper(matrix, visited, i, j, memo));
            }
        }
        return res;
    }
    
    private int helper(int[][] matrix, int[][] visited, int x, int y, int[][] memo) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        
        int length = 1;
        int val = matrix[x][y];
        visited[x][y] = 1;
        
        if (isValid(matrix, x-1, y, visited) && matrix[x - 1][y] > val) {
            length = Math.max(length, 1 + helper(matrix, visited, x - 1, y, memo));
        }
        if (isValid(matrix, x, y+1, visited)  && matrix[x][y + 1] > val) {
            length = Math.max(length, 1 + helper(matrix, visited, x, y + 1, memo));
        }
        if (isValid(matrix, x+1, y, visited) && matrix[x + 1][y] > val) {
            length = Math.max(length, 1 + helper(matrix, visited, x + 1, y, memo));
        }
        if (isValid(matrix, x, y-1, visited) && matrix[x][y - 1] > val) {
            length = Math.max(length, 1 + helper(matrix, visited, x, y - 1, memo));
        }
        visited[x][y] = 0;
        memo[x][y] = length;
        return length;
    }
    
    private boolean isValid(int[][] matrix, int x, int y, int[][] visited) {
        if (x<0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] != 0) {
            return false;
        }
        return true;
    }
}