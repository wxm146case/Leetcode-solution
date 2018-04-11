//N-Queens



class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		board[i][j] = '.';
        	}
        }
        List<List<String>> results = new ArrayList<>();
        dfsHelper(board, 0, results);
        return results;
    }
    
    private void dfsHelper (char[][] board, int colIndex, List<List<String>> results) {
    	
    	if (colIndex == board.length) {
    		results.add(construct(board));
            return;
    	}
        
    	for (int i = 0; i < board.length; i++) {
    		if (validate(board, i, colIndex)) {
    			board[i][colIndex] = 'Q';
    			dfsHelper(board, colIndex + 1, results);
    			board[i][colIndex] = '.';
    		}
    	}
    }
    
    private boolean validate(char[][] board, int x, int y) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i) ) {
					return false;
				}
			}
		}
		return true;
	}
    private List<String> construct(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			res.add(new String(board[i]));
		}
		return res;
	}
}