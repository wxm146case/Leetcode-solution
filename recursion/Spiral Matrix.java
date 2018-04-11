//Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        
        
        helper(matrix, row, col, res, 0);
        return res;
    }
    
    private void helper(int[][] matrix, int row, int col, List<Integer> res, int offset) {
        
        if (row == 0 || col == 0) {
            return;
        }
        
        if (row == 1) {
            for (int i = offset; i < col + offset; i++) {
                res.add(matrix[offset][i]);
            }
            return;
        }
        
        if (col == 1) {
            for (int i = offset; i < row + offset; i++) {
                res.add(matrix[i][offset]);
            }
            return;
        }
        
        for (int i = offset; i < col - 1 + offset; i++) {
                res.add(matrix[offset][i]);
            }
        for (int i = offset; i < row - 1 + offset; i++) {
                res.add(matrix[i][col - 1 + offset]);
            }
        for (int i = col - 1 + offset; i > offset; i--) {
                res.add(matrix[offset + row - 1][i]);
            }
        for (int i = offset + row - 1; i > offset; i--) {
                res.add(matrix[i][offset]);
            }
        
        helper(matrix, row - 2, col - 2, res, offset + 1);
        
    }
}